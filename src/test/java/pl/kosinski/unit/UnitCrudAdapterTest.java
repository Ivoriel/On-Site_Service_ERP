package pl.kosinski.unit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kosinski.client.Client;
import pl.kosinski.client.ClientCrudAdapter;
import pl.kosinski.client.ClientInfoDto;
import pl.kosinski.client.ClientRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UnitCrudAdapterTest {

    @Autowired
    UnitRepository unitRepository;
    @Autowired
    ClientRepository clientRepository;

    @Test
    void givenUnitNotPresentInDb_whenUnitAddedToDb_thenUnitShouldBeRetrievable() {
        UnitCrudAdapter unitCrudAdapter = new UnitCrudAdapter(unitRepository);
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(clientRepository);
        UnitInfoDto unit1 = new UnitInfoDto();
        unit1.setSerialNumber("789");
        ClientInfoDto client1 = new ClientInfoDto();
        client1.setName("testName1");
        clientCrudAdapter.saveClient(client1);
        unit1.setClient(clientRepository.getById(1L));
        unitCrudAdapter.saveUnit(unit1);
        unit1.setId(1L);
        assertEquals(unit1, unitCrudAdapter.findUnitbyId(1));
    }

    @Test
    void givenUnitIsPresentInDb_whenUnitIsRemoveFromDb_thenUnitShouldNotBeRetrievable() {
        UnitCrudAdapter unitCrudAdapter = new UnitCrudAdapter(unitRepository);
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(clientRepository);
        UnitInfoDto unit1 = new UnitInfoDto();
        unit1.setSerialNumber("789");
        ClientInfoDto client1 = new ClientInfoDto();
        client1.setName("testName1");
        clientCrudAdapter.saveClient(client1);
        unit1.setClient(clientRepository.getById(1L));
        unitCrudAdapter.saveUnit(unit1);
        unit1.setId(1L);
        assertEquals(unit1, unitCrudAdapter.findUnitbyId(1));
        unitCrudAdapter.deleteUnit(1);
        assertThrows(NoSuchElementException.class, () -> unitCrudAdapter.findUnitbyId(1));
    }

    @Test
    void givenUnitsArePresentInDb_whenUnitListIsCalled_thenUnitListShouldBeRetrievable() {
        UnitCrudAdapter unitCrudAdapter = new UnitCrudAdapter(unitRepository);
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(clientRepository);
        UnitInfoDto unit1 = new UnitInfoDto();
        unit1.setSerialNumber("789");
        ClientInfoDto client1 = new ClientInfoDto();
        client1.setName("testName1");
        clientCrudAdapter.saveClient(client1);
        unit1.setClient(clientRepository.getById(1L));
        unitCrudAdapter.saveUnit(unit1);
        unit1.setId(1L);
        UnitInfoDto unit2 = new UnitInfoDto();
        unit2.setSerialNumber("456");
        unit2.setClient(clientRepository.getById(1L));
        unitCrudAdapter.saveUnit(unit2);
        unit2.setId(2L);
        List<UnitInfoDto> unitList = List.of(unit1, unit2);
        assertEquals(unitList, unitCrudAdapter.findAllUnits());
    }

    @Test
    void getUnitsByClientId() {
        UnitCrudAdapter unitCrudAdapter = new UnitCrudAdapter(unitRepository);
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(clientRepository);
        UnitInfoDto unit1 = new UnitInfoDto();
        unit1.setSerialNumber("789");
        ClientInfoDto client1 = new ClientInfoDto();
        client1.setName("testName1");
        clientCrudAdapter.saveClient(client1);
        unit1.setClient(clientRepository.getById(1L));
        unitCrudAdapter.saveUnit(unit1);
        unit1.setId(1L);
        UnitInfoDto unit2 = new UnitInfoDto();
        unit2.setSerialNumber("456");
        unit2.setClient(clientRepository.getById(1L));
        unitCrudAdapter.saveUnit(unit2);
        unit2.setId(2L);
        List<UnitInfoDto> unitList = List.of(unit1, unit2);
        assertEquals(unitList, unitCrudAdapter.getUnitsByClientId(1));
    }
}
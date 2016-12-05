package be.cegeka.ng2boot.smurf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SmurfRepositoryIntegrationTest {

    @Resource
    private TestEntityManager tem;

    @Autowired
    private SmurfRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll();
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void findById_WhenSmurfWithGivenIdExists_ThenReturnsSmurf() throws Exception {
        LocalDate creationDate = LocalDate.now();
        Smurf persistedSmurf = tem.persist(SmurfTestBuilder.aDefaultSmurf()
                .withCreationDate(creationDate)
                .build());

        Smurf smurf = repository.findOne(persistedSmurf.getId());

        assertThat(smurf.getId()).isEqualTo(persistedSmurf.getId());
        assertThat(smurf.getName()).isEqualTo(SmurfTestBuilder.NAME);
        assertThat(smurf.getCreationDate()).isEqualTo(creationDate);
    }
}
package repo;


import com.Voting.Voting.entity.Voting;
import com.Voting.Voting.repsitory.VotingRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class votingRepoTest {

    private VotingRepo votingRepoTest;

    @Test
    void isPersonExitsById() {
        Voting personTest = new Voting("1","12345","54321",true);
        votingRepoTest.save(personTest);
        Boolean actualResult = votingRepoTest.findBy("1");
        assertThat(actualResult).isTrue();
    }
}

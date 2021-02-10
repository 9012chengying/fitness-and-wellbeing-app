package uk.ac.cf.nsa.web.phyt.AllClients.Data.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.ClientWorkout;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.Mapper.AllClientsMapper;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.Mapper.ClientWorkoutsMapper;

import java.util.List;

@Repository
public class ViewClientsRepoJdbc implements ViewClientsRepo {

private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ViewClientsRepoJdbc(JdbcTemplate myTemplate) {
        this.jdbcTemplate = myTemplate;
    }


   @Override
   public List<Client> GetAllClients(int trainerID){
       return jdbcTemplate.query (
               "SELECT distinct users.first_name,users.last_name,max(workouts.completed_at) as lastWorkout, client_id, count(workouts.id) as numOfWorkouts \n"+
                "from users inner join workouts on users.id = workouts.client_id \n"+
                "where users.user_role='Client' and trainer_id =? group by client_id", new AllClientsMapper(),new Object[]{trainerID}
       );
    }
    @Override
    public List<ClientWorkout> GetAllWorkouts(int clientID){
        return jdbcTemplate.query("SELECT distinct users.first_name,users.last_name,workouts.completed,workouts.completed_at ,workouts.created_at,workouts.complete_by,workouts.id \n" +
                "from users inner join workouts on users.id = workouts.client_id \n" +
                "where client_id =?", new ClientWorkoutsMapper(),new Object[]{clientID});
    }

}
//    SELECT distinct users.first_name,users.last_name,max(workouts.completed_at) as lastWorkout
//        from users inner join workouts on users.id = workouts.client_id
//        where users.user_role='Client' and trainer_id = 2 group by client_id

//    select distinct users.trainer_id,users.first_name,users.last_name,max(workouts.completed_at) as latestworkout
//        from workouts
//        inner join users
//        on users.client_id = workouts.client_id
//        where users.trainer_id = workouts.trainer_id = 1
//        group by users.client_id




//
//select users.trainer_id,users.first_name,users.last_name,workouts.completed_at
//        from users inner join workouts on users.trainer_id = workouts.trainer_id=1
//        inner join(select workouts.trainer_id,
//        max(workouts.completed_at)as LatestWorkout
//        from workouts
//        ) as NewWorkouts
//        on workouts.trainer_id = NewWorkouts.trainer_id
//        and workouts.completed_at = NewWorkouts.LatestWorkout

//
//THis works!!!
//select distinct users.trainer_id,users.first_name,users.last_name,max(workouts.completed_at)
//        from users
//        inner join workouts
//        on users.client_id = workouts.client_id
//        group by workouts.client_id


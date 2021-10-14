package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Before
    public void beforeJobTest() {}
    @Test
    public void testSettingJobId(){
        Job job = new Job();
        Job job2 = new Job();
        Assert.assertNotEquals(job.getId(), job2.getId());
    }
@Test
    public void testJobConstructorSetsAllFields(){
    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Assert.assertTrue(job.getName() instanceof String);
    Assert.assertTrue(job.getEmployer() instanceof Employer);
    Assert.assertTrue(job.getLocation() instanceof Location);
    Assert.assertTrue(job.getPositionType() instanceof PositionType);
    Assert.assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    Assert.assertEquals(job.getName(), "Product tester");
    Assert.assertEquals(job.getEmployer().toString(), "ACME");
    Assert.assertEquals(job.getLocation().toString(), "Desert");
    Assert.assertEquals(job.getPositionType().toString(), "Quality control");
    Assert.assertEquals(job.getCoreCompetency().toString(), "Persistence");

    }
    @Test
    public void testJobsForEquality(){
        Job job = new Job("Product tester",
                    new Employer("ACME"),
                    new Location("Desert"),
                    new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Assert.assertFalse(job == job2);

    }

    @Test
   public void testToStringStartsAndEndsWithNewLine(){

        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
                int lastIndex = job.toString().length() - 1;

        Assert.assertEquals(job.toString().charAt(0), '\n');
        Assert.assertEquals(job.toString().charAt(lastIndex),'\n');
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String actual = '\n' + "ID: "+ job.getId() + '\n' +
                "Name: Product tester" + '\n' +
                "Employer: ACME" + '\n' +
                "Location: Desert" + '\n' +
                "Position Type: Quality control" + '\n' +
                "Core Competency: Persistence" + '\n';

        Assert.assertEquals(job.toString(), actual);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expected = '\n' + "ID: " + job.getId() + '\n'+
                "Name: Product tester" + '\n' +
                "Employer: " + "Data not available" + '\n' +
                "Location: Desert" + '\n' +
                "Position Type: Quality control" + '\n' +
                "Core Competency: Persistence" + '\n'
        ;

        Assert.assertEquals(job.toString(), expected);


    }

}

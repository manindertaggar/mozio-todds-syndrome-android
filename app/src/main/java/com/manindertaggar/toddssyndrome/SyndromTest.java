package com.manindertaggar.toddssyndrome;

/**
 * Created by maninder on 16/7/17.
 */

public class SyndromTest {
    private int age = 50;
    private Boolean isMale = false;
    private Boolean haveMigranes = false;
    private Boolean usesHallucinogeninDrugs = false;


    private int probabity = 0;

    //here goes the logic of Syndrome test
    private void updateProbability() {
        int unitWeight = 100 / 4;//4 because there are 4 factors that will decide the syndrom

        int probabilty = 0;
        if (age <= 15) {
            probabilty += unitWeight;
        }

        if (isMale) {
            probabilty += unitWeight;
        }

        if (haveMigranes) {
            probabilty += unitWeight;
        }

        if (usesHallucinogeninDrugs) {
            probabilty += unitWeight;
        }

        this.probabity = probabilty;//update the classlevel probability
    }


    public SyndromTest(int age, Boolean isMale, Boolean haveMigranes, Boolean usesHallucinogeninDrugs) {
        this.age = age;
        this.isMale = isMale;
        this.haveMigranes = haveMigranes;
        this.usesHallucinogeninDrugs = usesHallucinogeninDrugs;
        updateProbability();
    }

    public SyndromTest() {

    }

    public void getProbability() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        updateProbability();
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
        updateProbability();
    }

    public Boolean getHaveMigranes() {
        return haveMigranes;
    }

    public void setHaveMigranes(Boolean haveMigranes) {
        this.haveMigranes = haveMigranes;
        updateProbability();
    }

    public Boolean getUsesHallucinogeninDrugs() {
        return usesHallucinogeninDrugs;
    }

    public void setUsesHallucinogeninDrugs(Boolean usesHallucinogeninDrugs) {
        this.usesHallucinogeninDrugs = usesHallucinogeninDrugs;
        updateProbability();
    }
}

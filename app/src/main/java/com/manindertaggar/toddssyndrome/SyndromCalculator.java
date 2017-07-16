package com.manindertaggar.toddssyndrome;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by maninder on 16/7/17.
 */

@Entity
public class SyndromCalculator {
    @Id(autoincrement = true)
    private Long id;
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


    public SyndromCalculator(int age, Boolean isMale, Boolean haveMigranes, Boolean usesHallucinogeninDrugs) {
        this.age = age;
        this.isMale = isMale;
        this.haveMigranes = haveMigranes;
        this.usesHallucinogeninDrugs = usesHallucinogeninDrugs;
        updateProbability();
    }

    public SyndromCalculator() {

    }


    @Generated(hash = 1226952326)
    public SyndromCalculator(Long id, int age, Boolean isMale, Boolean haveMigranes,
            Boolean usesHallucinogeninDrugs, int probabity) {
        this.id = id;
        this.age = age;
        this.isMale = isMale;
        this.haveMigranes = haveMigranes;
        this.usesHallucinogeninDrugs = usesHallucinogeninDrugs;
        this.probabity = probabity;
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


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getIsMale() {
        return this.isMale;
    }


    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }


    public int getProbabity() {
        return this.probabity;
    }


    public void setProbabity(int probabity) {
        this.probabity = probabity;
    }
}

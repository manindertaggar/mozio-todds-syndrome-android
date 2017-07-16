package com.manindertaggar.toddssyndrome;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Maninder Taggar on 16/7/17.
 */

@Entity
public class SyndromTest {
    @Expose
    @Id(autoincrement = true)
    private Long id;
    private int age = 50;
    private Boolean isMale = false;
    private Boolean haveMigranes = false;
    private Boolean isUploaded = false;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private Boolean usesHallucinogeninDrugs = false;
    private int time;
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

    @Generated(hash = 1159071299)
    public SyndromTest(Long id, int age, Boolean isMale, Boolean haveMigranes, Boolean isUploaded,
            Boolean usesHallucinogeninDrugs, int time, int probabity) {
        this.id = id;
        this.age = age;
        this.isMale = isMale;
        this.haveMigranes = haveMigranes;
        this.isUploaded = isUploaded;
        this.usesHallucinogeninDrugs = usesHallucinogeninDrugs;
        this.time = time;
        this.probabity = probabity;
    }

    public Boolean getUploaded() {
        return isUploaded;
    }

    public void setUploaded(Boolean uploaded) {
        isUploaded = uploaded;
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public Boolean getIsUploaded() {
        return this.isUploaded;
    }

    public void setIsUploaded(Boolean isUploaded) {
        this.isUploaded = isUploaded;
    }
}

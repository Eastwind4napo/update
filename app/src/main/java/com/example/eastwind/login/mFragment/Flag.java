package com.example.eastwind.login.mFragment;

/**
 * Created by Niroshana on 5/7/2017.
 */

public class Flag {
    private float tempFlag;
    private float lightFlag;
    private float humFlsg;
    private float soilFlag;

    public void setTempFlag(float tempFlag) {
        this.tempFlag = tempFlag;
    }

    public void setLightFlag(float lightFlag) {
        this.lightFlag = lightFlag;
    }

    public void setHumFlsg(float humFlsg) {
        this.humFlsg = humFlsg;
    }

    public void setSoilFlag(float soilFlag) {
        this.soilFlag = soilFlag;
    }

    public float getTempFlag() {
        return tempFlag;
    }

    public float getLightFlag() {
        return lightFlag;
    }

    public float getHumFlsg() {
        return humFlsg;
    }

    public float getSoilFlag() {
        return soilFlag;
    }
}

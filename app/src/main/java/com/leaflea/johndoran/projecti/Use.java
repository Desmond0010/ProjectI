package com.leaflea.johndoran.projecti;

import android.os.RemoteException;

/**
 * Created by John on 21/08/16.
 */
public class Use extends Main implements Runnable {
    private int option=0;
    public static String token;
    public Use(int option){
        this.setOption(option);
    }
    @Override
    public void run() {

        switch (getOption()){
            case 0:
                consumePurchase();
                break;
            default:
                break;
        }
    }

    public void consumePurchase(){
        try {
            int response = mHelper.getmService().consumePurchase(3, getPackageName(), getToken());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        token = token;
    }
}

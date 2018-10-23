package com.leaflea.johndoran.projecti;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.leaflea.johndoran.projecti.util.IabBroadcastReceiver;
import com.leaflea.johndoran.projecti.util.IabBroadcastReceiver.IabBroadcastListener;
import com.leaflea.johndoran.projecti.util.IabHelper;
import com.leaflea.johndoran.projecti.util.IabHelper.IabAsyncInProgressException;
import com.leaflea.johndoran.projecti.util.IabResult;
import com.leaflea.johndoran.projecti.util.Inventory;
import com.leaflea.johndoran.projecti.util.Purchase;

import java.util.ArrayList;

/**
 * Created by John Doran on 02/08/2015.
 *
 * Created by Desmond Doran over the course of two years.
 * Desmond Doran. All rights reserved.
 * Copyright 2016, Desmond Doran, All rights reserved.
 */

public class Main extends Activity implements IabBroadcastListener {
    static final String TAG = "ProjectI";

    private static String[] skus = {
            "gold_10000", "gold_50000", "gold_150000", "gold_500000",
            "gem_100", "flying_saucer", "theme_paperplane", "no_ads"
    };


    Boolean halt = false;

    public static String[] getSkus() {
        return skus;
    }

    public static void setSkus(String[] skus) {
        Main.skus = skus;
    }

    @Override
    public void onPause() {
        super.onPause();

        halt = true;

        /*while(false){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        MyRenderer.pauseMenuActivated = true;


    }

    public static Boolean debugging = false;

    public void onStop() {
        super.onStop();

        halt = true;

        /*while(false){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        MyRenderer.pauseMenuActivated = true;


    }

    //
    Boolean af = true;

    @Override
    public void onResume() {
        super.onResume();
        halt = false;

        //MyRenderer.pauseMenuActivated=false;

        //while(af){}

        //mView.requestFocus();
        //mView.requestFocusFromTouch();
        //MyRenderer.getmView().requestFocus();
        //MyRenderer.getmView().requestFocusFromTouch();


    }

    public void onRestart() {
        super.onRestart();
        onResume();
    }

    public static GLSurfaceView getmView() {
        return mView;
    }

    public static void setmView(GLSurfaceView mView) {
        Main.mView = mView;
    }

    @Override
    public void receivedBroadcast() {
        // Received a broadcast notification that the inventory of items has changed
        Log.d(TAG, "Received broadcast notification. Querying inventory.");


        try {
            mHelper.queryInventoryAsync(mGotInventoryListener);
        } catch (IabAsyncInProgressException e) {
            if (debugging) {
                complain("Error querying inventory. Another async operation in progress.");
            }
        }
    }

    public static GLSurfaceView mView;
    private MyRenderer myRenderer;

    //////////public IInAppBillingService mService;///////////
    public Bundle skuDetails;
    Bundle ownedItems;


    Intent serviceIntent;
    // The helper object
    IabHelper mHelper;
    IabBroadcastReceiver mBroadcastReceiver;
    String st;


    public static AdView mAdView;

    //get this key from google play developer console.

    public Boolean isTouch() {
        return mView.isFocusableInTouchMode();
    }

    ServiceConnection mServiceConn;

    public void onCreate(Bundle savedInstanceState) {


        st = I097022c421964b818e272d163077198b.jk();

        /*
        mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                mService = IInAppBillingService.Stub.asInterface(service);
            }
        };*/


        // Create the helper, passing it our context and the public key to verify signatures with
        Log.d(TAG, "Creating IAB helper.");
        mHelper = new IabHelper(this, st);


        // enable debug logging (for a production application, you should set this to false).
        mHelper.enableDebugLogging(true);

        Log.d(TAG, "Starting setup.");


        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                Log.d(TAG, "Setup finished.");

                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    complain("Problem setting up in-app billing: " + result);
                    return;
                }

                // Have we been disposed of in the meantime? If so, quit.
                if (mHelper == null) {
                    Log.d(TAG, "mHelper null.");

                    return;
                }

                // Important: Dynamically register for broadcast messages about updated purchases.
                // We register the receiver here instead of as a <receiver> in the Manifest
                // because we always call getPurchases() at startup, so therefore we can ignore
                // any broadcasts sent while the app isn't running.
                // Note: registering this listener in an Activity is a bad idea, but is done here
                // because this is a SAMPLE. Regardless, the receiver must be registered after
                // IabHelper is setup, but before first call to getPurchases().
                mBroadcastReceiver = new IabBroadcastReceiver(Main.this);
                IntentFilter broadcastFilter = new IntentFilter(IabBroadcastReceiver.ACTION);
                registerReceiver(mBroadcastReceiver, broadcastFilter);

                // IAB is fully set up. Now, let's get an inventory of stuff we own.
                Log.d(TAG, "Setup successful. Querying inventory.");


                try {
                    Log.d(TAG, "Setup successful. 1");
                    if (mHelper == null) {
                        Log.d(TAG, "mHelper null.");
                        ;
                        return;
                    }

                    mHelper.queryInventoryAsync(mGotInventoryListener);
                    Log.d(TAG, "Setup successful. Done");
                } catch (IabAsyncInProgressException e) {
                    if (debugging) {
                        complain("Error querying inventory. Another async operation in progress.");
                    }
                }


            }
        });


        //mServiceConn=mHelper.getmServiceConn();









        /*mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                Log.d(TAG, "mService CONNECTED");

                mService = IInAppBillingService.Stub.asInterface(service);
            }
        };*/
        Log.d(TAG, "before serviceIntent");


        serviceIntent =
                new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        Log.d(TAG, "before serviceIntent bind");

        if (serviceIntent == null) {
            Log.d(TAG, "serviceIntent null");

        }


        if (mServiceConn == null) {
            Log.d(TAG, "mServiceConn null");

        }
        bindService(serviceIntent, mHelper.getmServiceConn(), Context.BIND_AUTO_CREATE);


        /////////////////////Log.d(TAG, "after serviceIntent");

        /*
        try {
            ownedItems = mService.getPurchases(3, getPackageName(), "inapp", null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/


        //skuDetails=getSkuDetailsFromStore();///////////////////////////////////////////

        ////////////////////////


        /*int response = skuDetails.getInt("RESPONSE_CODE");//if 0 then everything went well
        if (response == 0) {
            ArrayList<String> responseList
                    = skuDetails.getStringArrayList("DETAILS_LIST");

            for (String thisResponse : responseList) {
                try {
                JSONObject object = new JSONObject(thisResponse);
                String sku = object.getString("productId");
                String price = null;

                    price = object.getString("price");

                //if (sku.equals("premiumUpgrade")) mPremiumUpgradePrice = price;
                //else if (sku.equals("gas")) mGasPrice = price;

                } catch (JSONException e) {
                    Log.e("RESPONSE_CODE","RESPONSE_CODE-error");
                    e.printStackTrace();
                }
            }
        }*/
////        View decorView = getWindow().getDecorView();
////// Hide the status bar.
////        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
////        decorView.setSystemUiVisibility(uiOptions);
////// Remember that you should never show the action bar if the
////// status bar is hidden, so hide that too if necessary.                     I think this is UNNECESSARY


        ActionBar actionBar = getActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);

        Log.d(TAG, "P1");





        //mView = new GLSurfaceView(this);
        myRenderer = new MyRenderer(this);

        myRenderer.setmyMain(this);


        myRenderer.checkAndLoad();

        if(!myRenderer.getNoads()){
            setContentView(R.layout.activity_fullscreen);


            mAdView = (AdView) findViewById(R.id.adView);

            AdRequest adRequest = new AdRequest.Builder().build();
            //mAdView.hashCode();
            mAdView.loadAd(adRequest);


            myRenderer.setBannerHeight(mAdView.getHeight());


            Log.d(TAG, "P2");
            mView = (GLSurfaceView) findViewById(R.id.mView);
            mAdView.bringToFront();

        }else{
            setContentView(R.layout.activity_noads);
            myRenderer.setBannerHeight(0);
            mView = (GLSurfaceView) findViewById(R.id.mView);




        }
        mView.setRenderer(myRenderer);
        //setContentView(mView);

        myRenderer.setmView(mView);


        //changeLayout(477, 790, false);
        //changeLayout(480, 790, false);

        ///////mService=mHelper.getmService();/////////


        time = System.nanoTime();
        Log.d(TAG, "mServiceSet " + Long.toString(time));



        Log.d(TAG, "mServiceSet 1 " + Long.toString(time));

        String t = Integer.toString(R.string.banner_ad_unit_id);
        MobileAds.initialize(getApplicationContext(), t);


        hideAd();


        //FrameLayout layout = (FrameLayout) findViewById(R.id.adView);
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layout.getLayoutParams();


        //myRenderer.setBannerHeight(AdSize.BANNER.getHeightInPixels(this));





        /*
        if(mService!=null) {
            buyItem("gold_10000");
        }else{////awful coding
            try {
                Thread.sleep(6000,0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //buyItem("gold_10000");

        }*/
        ////////////////////////
        /*
        SystemUiHider h=new SystemUiHider(this,mView,0x2) {
            @Override
            public void setup() {

            }

            @Override
            public boolean isVisible() {
                return false;
            }

            @Override
            public void hide() {

            }

            @Override
            public void show() {

            }
        };
        h.hide();*/


    }

    public void domService() {
        mServiceConn = mHelper.getmServiceConn();
        if (mServiceConn == null) {
            Log.d(TAG, "mServiceConn null");

        }
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
        //mService=mHelper.getmService();

    }

    public static long time = 0;




    /*
    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query inventory: " + result);
                return;
            }

            Log.d(TAG, "Query inventory was successful.");

            /*
             * Check for items we own. Notice that for each purchase, we check
             * the developer payload to see if it's correct! See
             * verifyDeveloperPayload().
             //////////////////////////

            Purchase[] premiumPurchases=new Purchase[skus.length];
            for(int c=0;c<skus.length;c++) {
                 premiumPurchases[c] = inventory.getPurchase(skus[c]);
            }

            ArrayList<String> skuslist=new ArrayList<>(Arrays.asList(skus));

            for(int c=0;c<skus.length;c++) {
                //int k=skuslist.indexOf(premiumPurchases[c].getSku());

                if (premiumPurchases[c] != null ) {
                    if(verifyDeveloperPayload(premiumPurchases[c])) {
                        Log.d(TAG, "We have " + skus[c] + ". Consuming it.");
                        try {




                            //mHelper.consumeAsync(inventory.getPurchase(skus[c]), mConsumeFinishedListener);






                            if(inventory.getPurchase(skus[c]).getPurchaseState()==0) {
                                switch (c) {
                                    case 0:
                                        MyRenderer.gold = MyRenderer.gold + 10000;
                                        MyRenderer.save();
                                        break;
                                    case 1:
                                        MyRenderer.gold = MyRenderer.gold + 50000;
                                        MyRenderer.save();
                                        break;
                                    case 2:
                                        MyRenderer.gold = MyRenderer.gold + 150000;
                                        MyRenderer.save();
                                        break;
                                    case 3:
                                        MyRenderer.gold = MyRenderer.gold + 500000;
                                        MyRenderer.save();
                                        break;
                                    case 4:
                                        MyRenderer.gems = MyRenderer.gems + 100;
                                        MyRenderer.save();
                                        break;
                                    case 5:
                                        MyRenderer.setFlying_saucer(true);
                                        MyRenderer.save();
                                        break;
                                    case 6:
                                        MyRenderer.setPptheme(true);
                                        MyRenderer.save();
                                        break;
                                    case 7:
                                        MyRenderer.setNoads(true);
                                        MyRenderer.save();
                                        break;
                                    default:
                                        break;
                                }
                            }else if(c>=0&&c<8&&inventory.getPurchase(skus[c]).getPurchaseState()==7) {
                                mHelper.consumeAsync(inventory.getPurchase(skus[c]), mConsumeFinishedListener);
                            }
                            return;


                        } catch (IabAsyncInProgressException e) {
                            complain("Error consuming gas. Another async operation in progress.");
                        }


                        return;
                    }
                }
            }
            //"gold_10000","gold_50000","gold_150000","gold_500000",
            //"gems_100","flying_saucer","theme_paperplane","no_ads"
            /*
            // Do we have the premium upgrade?
            Purchase premiumPurchase = inventory.getPurchase(SKU_PREMIUM);
            mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
            Log.d(TAG, "User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));

            // First find out which subscription is auto renewing
            Purchase gasMonthly = inventory.getPurchase(SKU_INFINITE_GAS_MONTHLY);
            Purchase gasYearly = inventory.getPurchase(SKU_INFINITE_GAS_YEARLY);
            if (gasMonthly != null && gasMonthly.isAutoRenewing()) {
                mInfiniteGasSku = SKU_INFINITE_GAS_MONTHLY;
                mAutoRenewEnabled = true;
            } else if (gasYearly != null && gasYearly.isAutoRenewing()) {
                mInfiniteGasSku = SKU_INFINITE_GAS_YEARLY;
                mAutoRenewEnabled = true;
            } else {
                mInfiniteGasSku = "";
                mAutoRenewEnabled = false;
            }

            // The user is subscribed if either subscription exists, even if neither is auto
            // renewing
            mSubscribedToInfiniteGas = (gasMonthly != null && verifyDeveloperPayload(gasMonthly))
                    || (gasYearly != null && verifyDeveloperPayload(gasYearly));
            Log.d(TAG, "User " + (mSubscribedToInfiniteGas ? "HAS" : "DOES NOT HAVE")
                    + " infinite gas subscription.");
            if (mSubscribedToInfiniteGas) mTank = TANK_MAX;

            // Check for gas delivery -- if we own gas, we should fill up the tank immediately
            Purchase gasPurchase = inventory.getPurchase(SKU_GAS);
            if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                Log.d(TAG, "We have gas. Consuming it.");
                try {
                    mHelper.consumeAsync(inventory.getPurchase(SKU_GAS), mConsumeFinishedListener);
                } catch (IabAsyncInProgressException e) {
                    complain("Error consuming gas. Another async operation in progress.");
                }
                return;
            }

            updateUi();
            setWaitScreen(false);
            Log.d(TAG, "Initial inventory query finished; enabling main UI.");///////////////
        }
    };*/

    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query inventory: " + result);
                return;
            }

            Log.d(TAG, "Query inventory was successful.");

            /*
             * Check for items we own. Notice that for each purchase, we check
             * the developer payload to see if it's correct! See
             * verifyDeveloperPayload().
             */

            Purchase[] premiumPurchases = new Purchase[skus.length];
            for (int c = 0; c < skus.length; c++) {
                premiumPurchases[c] = inventory.getPurchase(skus[c]);
            }

            for (int c = 0; c < skus.length; c++) {
                //turned off
                //turned off
                //turned off
                //turned off
                //turned off
                //turned off
                //turned off

                if (false && premiumPurchases[c] != null && verifyDeveloperPayload(premiumPurchases[c])) {
                    Log.d(TAG, "We have " + skus[c] + ". Consuming it.");
                    try {
                        //if(c>=0&&c<8) {
                        //mHelper.consumeAsync(inventory.getPurchase(skus[c]), mConsumeFinishedListener);
                        mHelper.consumeAsync(premiumPurchases[c], mConsumeFinishedListener);

                        //}

                        int k = premiumPurchases[c].getSku().hashCode();

                        /*int[] l={
                                skus[0].hashCode(), skus[1].hashCode(),
                                skus[2].hashCode(), skus[3].hashCode(),
                                skus[4].hashCode(), skus[5].hashCode(),
                                skus[6].hashCode(), skus[7].hashCode()

                        };*/
/*
                        int l0="gold_10000".hashCode()      ;
                        int l1="gold_50000".hashCode()      ;
                        int l2="gold_150000".hashCode()     ;
                        int l3="gold_500000".hashCode()     ;
                        int l4="gem_100".hashCode()         ;
                        int l5="flying_saucer".hashCode()   ;
                        int l6="theme_paperplane".hashCode();
                        int l7="no_ads".hashCode()          ;
*/


                        int[] l = {
                                -1257494766,
                                -1253800682,
                                -323014429,
                                -213115430,
                                -81314559,
                                -979770695,
                                -741836666,
                                -1040323278};

                        switch (k) {

                            case -1257494766:
                                MyRenderer.gold = MyRenderer.gold + 10000;
                                MyRenderer.save();
                                break;
                            case -1253800682:
                                MyRenderer.gold = MyRenderer.gold + 50000;
                                MyRenderer.save();
                                break;
                            case -323014429:
                                MyRenderer.gold = MyRenderer.gold + 150000;
                                MyRenderer.save();
                                break;
                            case -213115430:
                                MyRenderer.gold = MyRenderer.gold + 500000;
                                MyRenderer.save();
                                break;
                            case -81314559:
                                MyRenderer.gems = MyRenderer.gems + 100;
                                MyRenderer.save();
                                break;
                            case -979770695:
                                MyRenderer.setFlying_saucer(true);
                                MyRenderer.save();
                                break;
                            case -741836666:
                                MyRenderer.setPptheme(true);
                                MyRenderer.save();
                                break;
                            case -1040323278:
                                MyRenderer.setNoads(true);
                                MyRenderer.save();
                                break;


                            default:
                                break;

                        }
                    } catch (IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }


                    return;
                }
            }
            //"gold_10000","gold_50000","gold_150000","gold_500000",
            //"gems_100","flying_saucer","theme_paperplane","no_ads"
            /*
            // Do we have the premium upgrade?
            Purchase premiumPurchase = inventory.getPurchase(SKU_PREMIUM);
            mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
            Log.d(TAG, "User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));

            // First find out which subscription is auto renewing
            Purchase gasMonthly = inventory.getPurchase(SKU_INFINITE_GAS_MONTHLY);
            Purchase gasYearly = inventory.getPurchase(SKU_INFINITE_GAS_YEARLY);
            if (gasMonthly != null && gasMonthly.isAutoRenewing()) {
                mInfiniteGasSku = SKU_INFINITE_GAS_MONTHLY;
                mAutoRenewEnabled = true;
            } else if (gasYearly != null && gasYearly.isAutoRenewing()) {
                mInfiniteGasSku = SKU_INFINITE_GAS_YEARLY;
                mAutoRenewEnabled = true;
            } else {
                mInfiniteGasSku = "";
                mAutoRenewEnabled = false;
            }

            // The user is subscribed if either subscription exists, even if neither is auto
            // renewing
            mSubscribedToInfiniteGas = (gasMonthly != null && verifyDeveloperPayload(gasMonthly))
                    || (gasYearly != null && verifyDeveloperPayload(gasYearly));
            Log.d(TAG, "User " + (mSubscribedToInfiniteGas ? "HAS" : "DOES NOT HAVE")
                    + " infinite gas subscription.");
            if (mSubscribedToInfiniteGas) mTank = TANK_MAX;

            // Check for gas delivery -- if we own gas, we should fill up the tank immediately
            Purchase gasPurchase = inventory.getPurchase(SKU_GAS);
            if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                Log.d(TAG, "We have gas. Consuming it.");
                try {
                    mHelper.consumeAsync(inventory.getPurchase(SKU_GAS), mConsumeFinishedListener);
                } catch (IabAsyncInProgressException e) {
                    complain("Error consuming gas. Another async operation in progress.");
                }
                return;
            }

            updateUi();
            setWaitScreen(false);
            Log.d(TAG, "Initial inventory query finished; enabling main UI.");*/

        }
    };

    /*public void methodWhichCouldBeAdaptedToDisplayPurchasedItems(){
        int response = ownedItems.getInt("RESPONSE_CODE");
        if (response == 0) {
            ArrayList<String> ownedSkus =
                    ownedItems.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String>  purchaseDataList =
                    ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String>  signatureList =
                    ownedItems.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            String continuationToken =
                    ownedItems.getString("INAPP_CONTINUATION_TOKEN");

            for (int i = 0; i < purchaseDataList.size(); ++i) {
                String purchaseData = purchaseDataList.get(i);
                String signature = signatureList.get(i);
                String sku = ownedSkus.get(i);

                // do something with this purchase information
                // e.g. display the updated list of products owned by user
            }

            // if continuationToken != null, call getPurchases again
            // and pass in the token to retrieve more items
        }
    }*/

    // Called when consumption is complete
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);

            /*
            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            // We know this is the "gas" sku because it's the only one we consume,
            // so we don't check which sku was consumed. If you have more than one
            // sku, you probably should check...
            if (result.isSuccess()) {
                // successfully consumed, so we apply the effects of the item in our
                // game world's logic, which in our case means filling the gas tank a bit
                Log.d(TAG, "Consumption successful. Provisioning.");
                mTank = mTank == TANK_MAX ? TANK_MAX : mTank + 1;
                saveData();
                alert("You filled 1/4 tank. Your tank is now " + String.valueOf(mTank) + "/4 full!");
            }
            else {
                complain("Error while consuming: " + result);
            }
            updateUi();
            setWaitScreen(false);
            Log.d(TAG, "End consumption flow.");
            */
        }
    };


    public void changeLayout(float Screen_Width,float Screen_Height,float propotionGL) {

        //FrameLayout layout = (FrameLayout) findViewById(R.id.frame);
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layout.getLayoutParams();
        //params.height=(int)(Screen_Height*propotionGL);
        //params.width =(int)(Screen_Width);
        //layout.setLayoutParams(params);


    /*FrameLayout ad = (FrameLayout) findViewById(R.id.adView);
    FrameLayout.LayoutParams adparams = (FrameLayout.LayoutParams) ad.getLayoutParams();
    params.height=(int)(Screen_Height*propotionGL);
    params.width =(int)(Screen_Width);
    ad.setLayoutParams(adparams);*/
    }

    public void hideAd(){
        //FrameLayout ad = (FrameLayout) findViewById(R.id.adView);

        ////////mView.bringToFront();
    }


    public void changeLayout(float Screen_Width,float Screen_Height,Boolean noads) {
        //FrameLayout ad = (FrameLayout) findViewById(R.id.adframe);
        //FrameLayout.LayoutParams adparams = (FrameLayout.LayoutParams) ad.getLayoutParams();


        /////////if(noads){
        /////////    FrameLayout layout = (FrameLayout) findViewById(R.id.frame);
        /////////    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layout.getLayoutParams();
        /////////    params.height=(int)(Screen_Height);
        /////////    params.width =(int)(Screen_Width);
        /////////    layout.setLayoutParams(params);
        /////////}else{
        /////////    FrameLayout layout = (FrameLayout) findViewById(R.id.frame);
        /////////    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layout.getLayoutParams();
        /////////    params.height=(int)(Screen_Height-65f);
        /////////    params.width =(int)(Screen_Width);
        /////////    params.bottomMargin=(int)(65f);
        /////////    layout.setLayoutParams(params);
        /////////}


        //ad.setLayoutParams(adparams);

    }

    public boolean onTouchEvent(MotionEvent event){

        return myRenderer.onTouchEvent(event);
    }

    public boolean onTouch(View v, MotionEvent event){

        return myRenderer.onTouch(v, event);
    }

    public void onUserInteraction (){

    }

    /////////public Bundle getSkuDetailsFromStore(){
    /////////    try {
    /////////        return mService.getSkuDetails(3,
    /////////                getPackageName(), "inapp", itemsAvailableForPurchase());
    /////////    } catch (RemoteException e) {
    /////////        e.printStackTrace();
    /////////        Log.e("getSkuDetailsFromStore","getSkuDetailsFromStore-error");
    /////////        return null;
    /////////    }
    /////////}
    public Bundle itemsAvailableForPurchase(){
        ArrayList<String> skuList = new ArrayList<String>();
        skuList.add("gold_10000");
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
        return querySkus;
    }


    /*@Override
    public void onDestroy() {
        super.onDestroy();
        //if (mService != null) {
        //    unbindService(mServiceConn);
        //}
    }*/

    // We're being destroyed. It's important to dispose of the helper here!
    @Override
    public void onDestroy() {
        super.onDestroy();

        if(myRenderer!=null){
            //myRenderer.save();
        }

        // very important:
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }

        // very important:
        Log.d(TAG, "Destroying helper.");
        if (mHelper != null) {
            mHelper.disposeWhenFinished();
            mHelper = null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_BACK:
                myRenderer.onTouchFake();
                myRenderer.turnsSinceBackButton=0;

                break;
            //case KeyEvent.KEYCODE_HOME:
            //    onPause();
            //    break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        //Log.d("CDA", "onBackPressed Called");
        //Intent setIntent = new Intent(Intent.ACTION_MAIN);
        //setIntent.addCategory(Intent.CATEGORY_HOME);
        //setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(setIntent);
//
        //return;
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            int responseCode = data.getIntExtra("RESPONSE_CODE", 0);
            String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
            String dataSignature = data.getStringExtra("INAPP_DATA_SIGNATURE");

            if (resultCode == RESULT_OK) {
                try {
                    JSONObject jo = new JSONObject(purchaseData);
                    String sku = jo.getString("productId");
                    alert("You have bought the " + sku + ". Excellent choice!");


                    //Do whatever action the purchase triggers


                    Use.setToken(jo.getString("purchaseToken"));
                    Thread t=new Thread(new Use(0));
                }
                catch (JSONException e) {
                 //   alert("Failed to parse purchase data.");
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (mHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        }
        else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }

    boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();

        /*
         * TODO: verify that the developer payload of the purchase is correct. It will be
         * the same one that you sent when initiating the purchase.
         *
         * WARNING: Locally generating a random string when starting a purchase and
         * verifying it here might seem like a good approach, but this will fail in the
         * case where the user purchases an item on one device and then uses your app on
         * a different device, because on the other device you will not have access to the
         * random string you originally generated.
         *
         * So a good developer payload has these characteristics:
         *
         * 1. If two different users purchase an item, the payload is different between them,
         *    so that one user's purchase can't be replayed to another user.
         *
         * 2. The payload must be such that you can verify it even when the app wasn't the
         *    one who initiated the purchase flow (so that items purchased by the user on
         *    one device work on other devices owned by the user).
         *
         * Using your own server to store and verify developer payloads across app
         * installations is recommended.
         */

        return true;
    }


    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
                Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);


                // if we were disposed of in the meantime, quit.
                if (mHelper == null) return;

                if (result.isFailure()) {
                    complain("Error purchasing: " + result);
                    return;
                }
                if (!verifyDeveloperPayload(purchase)) {
                    complain("Error purchasing. Authenticity verification failed.");
                    return;
                }

                Log.d(TAG, "Purchase successful.");

                //if (purchase.getSku().equals(SKU_GOLD_10000)) {
                //    // bought 1/4 tank of gas. So consume it.
                //    Log.d(TAG, "Purchase gold 10000.");
                //    //this is where you consume purchase so that it can be bought again
                //    /*try {
                //        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                //    } catch (IabAsyncInProgressException e) {
                //        complain("Error consuming gas. Another async operation in progress.");
                //        return;
                //    }*/
                //}


                Purchase premiumPurchases;
                premiumPurchases = purchase;

                for (int c = 0; c < skus.length; c++) {
                    if (premiumPurchases != null && verifyDeveloperPayload(premiumPurchases) && premiumPurchases.getSku().equals(skus[c])) {
                        Log.d(TAG, "We have " + skus[c] + ". Consuming it.");

                        try {
                            mHelper.consumeAsync(premiumPurchases, mConsumeFinishedListener);
                        } catch (IabAsyncInProgressException e) {
                            e.printStackTrace();
                        }

                        switch (c) {

                            case 0:
                                MyRenderer.gold = MyRenderer.gold + 10000;
                                MyRenderer.save();
                                break;
                            case 1:
                                MyRenderer.gold = MyRenderer.gold + 50000;
                                MyRenderer.save();
                                break;
                            case 2:
                                MyRenderer.gold = MyRenderer.gold + 150000;
                                MyRenderer.save();
                                break;
                            case 3:
                                MyRenderer.gold = MyRenderer.gold + 500000;
                                MyRenderer.save();
                                break;
                            case 4:
                                MyRenderer.gems = MyRenderer.gems + 100;
                                MyRenderer.save();
                                break;
                            case 5:
                                MyRenderer.setFlying_saucer(true);
                                MyRenderer.save();
                                break;
                            case 6:
                                MyRenderer.setPptheme(true);
                                MyRenderer.save();
                                break;
                            case 7:
                                MyRenderer.setNoads(true);
                                MyRenderer.save();
                                break;
                            default:
                                break;
                        }
                        return;
                    }
                }
                //else if (purchase.getSku().equals(SKU_PREMIUM)) {
                //    // bought the premium upgrade!
                //    Log.d(TAG, "Purchase is premium upgrade. Congratulating user.");
                //    alert("Thank you for upgrading to premium!");
                //}

        }
    };

    public void buyItem(String sku){
        /*try {
            Log.d(TAG, "11-buying");
            Bundle buyIntentBundle = mService.getBuyIntent(3, getPackageName(),
                    sku, "inapp", developerPayload);//Problem?
            Log.d(TAG, "12");
            PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");
            Log.d(TAG, "13");*/

            //try {
            //    startIntentSenderForResult(pendingIntent.getIntentSender(),
            //            1001, new Intent(), Integer.valueOf(0), Integer.valueOf(0),
            //            Integer.valueOf(0));

                try {
                    mHelper.launchPurchaseFlow(this, sku, RC_REQUEST,
                            mPurchaseFinishedListener, developerPayload);
                    Log.d(TAG, "14");

                } catch (IabAsyncInProgressException e) {
                    e.printStackTrace();
                }
                //Log.d(TAG, "15");

            //} catch (IntentSender.SendIntentException e) {
            //    e.printStackTrace();
            //}
        /*} catch (RemoteException e) {
            e.printStackTrace();
        }*/
    }

    void buyGold1(){


    }

    void complain(String message) {
        Log.e(TAG, "**** TrivialDrive Error: " + message);
        alert("Error: " + message);
    }

    void alert(String message) {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setMessage(message);
        bld.setNeutralButton("OK", null);
        Log.d(TAG, "Showing alert dialog: " + message);
        bld.create().show();
    }

    static final String SKU_GOLD_10000 = "gold_10000";
    // (arbitrary) request code for the purchase flow
    static final int RC_REQUEST = 10001;
    public static String developerPayload="";
    //public void buygold_10000(){
    //    /* TODO: for security, generate your payload here for verification. See the comments on
    //     *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
    //     *        an empty string, but on a production app you should carefully generate this. */
    //    String payload = developerPayload;
    //    try {
    //        mHelper.launchPurchaseFlow(this, SKU_GOLD_10000, RC_REQUEST,
    //                mPurchaseFinishedListener, payload);
    //    } catch (IabAsyncInProgressException e) {
    //        complain("Error launching purchase flow. Another async operation in progress.");
    //    }
    //}




    public static class I097022c421964b818e272d163077198b {
        public static class I9ed5d2415a914741ae9611a12a65292d {
            public static class Iaeb297f05434460ea3f1f8db69c60dd9 {
                public static class I5ee3b359e87e4df0972594aca43e5589 {
                    public static class Ieb84fd863d7e4d9b8809a6b016d60883 {
                        public static class Iba109cf5b73945a1a51c7dd7ce8cccc0 {
                            public static String jk() {
                                return "MIIBIjANBgkq";
                            }
                        }
                        public static class I4c2925c3f4ec4551ba70f4995c0e72ff {
                            public static String jk() {
                                return "hkiG9w0BAQEF";
                            }
                        }
                        public static String jk() {
                            return Iba109cf5b73945a1a51c7dd7ce8cccc0.jk() + I4c2925c3f4ec4551ba70f4995c0e72ff.jk();
                        }
                    }
                    public static class Ibe054cccc6034142a79c2e70c4bbda81 {
                        public static class I45eff7d940664646ad792445912aa64e {
                            public static String jk() {
                                return "AAOCAQ8AMIIB";
                            }
                        }
                        public static class I86268e3c644e4982913264b9b51b2822 {
                            public static String jk() {
                                return "CgKCAQEAscK5h";
                            }
                        }
                        public static String jk() {
                            return I45eff7d940664646ad792445912aa64e.jk() + I86268e3c644e4982913264b9b51b2822.jk();
                        }
                    }
                    public static String jk() {
                        return Ieb84fd863d7e4d9b8809a6b016d60883.jk() + Ibe054cccc6034142a79c2e70c4bbda81.jk();
                    }
                }
                public static class Icb18c67e3b9c42f0be7d3b5e0a09ae02 {
                    public static class Ia1f614e1b4a4428193d731b57f0e32d9 {
                        public static class Ic21a4cfe42104b09a90ca45d2256ed56 {
                            public static String jk() {
                                return "29AVSOp1jEjg";
                            }
                        }
                        public static class I10381a50666b4954b66c7a82d24921ea {
                            public static String jk() {
                                return "Ei4p7vC9mthh";
                            }
                        }
                        public static String jk() {
                            return Ic21a4cfe42104b09a90ca45d2256ed56.jk() + I10381a50666b4954b66c7a82d24921ea.jk();
                        }
                    }
                    public static class I7c93c4ae5f504670a3e393663d61d4a4 {
                        public static class I0866eea88d9c4810aaa7d975be2904ba {
                            public static String jk() {
                                return "T7rhHVg8rx1q";
                            }
                        }
                        public static class I98262ebb3b00402d9dab95a7919ec211 {
                            public static String jk() {
                                return "Rp9Xc4RTkIL9u";
                            }
                        }
                        public static String jk() {
                            return I0866eea88d9c4810aaa7d975be2904ba.jk() + I98262ebb3b00402d9dab95a7919ec211.jk();
                        }
                    }
                    public static String jk() {
                        return Ia1f614e1b4a4428193d731b57f0e32d9.jk() + I7c93c4ae5f504670a3e393663d61d4a4.jk();
                    }
                }
                public static String jk() {
                    return I5ee3b359e87e4df0972594aca43e5589.jk() + Icb18c67e3b9c42f0be7d3b5e0a09ae02.jk();
                }
            }
            public static class If135d68459f14183b5ddae56716a2a22 {
                public static class I753174b0e6324b95b9bc5637df2de06a {
                    public static class I761bb71aa0a7484089d26c32f2150c4b {
                        public static class Ic9d7bf7521e64e5ba822108d9b1b7ba8 {
                            public static String jk() {
                                return "pw/0HLaaivZH";
                            }
                        }
                        public static class Ia7ca26a8c82647198941029664de38f0 {
                            public static String jk() {
                                return "/K2d1c671MzV";
                            }
                        }
                        public static String jk() {
                            return Ic9d7bf7521e64e5ba822108d9b1b7ba8.jk() + Ia7ca26a8c82647198941029664de38f0.jk();
                        }
                    }
                    public static class I4dadf356035d4fc39db0aae712059044 {
                        public static class I135bb5bc89f049e88a67ebd0ff95a015 {
                            public static String jk() {
                                return "KdR4uMbe9Z7p";
                            }
                        }
                        public static class Iee442ee7a8db419b9a4641301aa9a3dd {
                            public static String jk() {
                                return "zQIAm/mId+ZiN";
                            }
                        }
                        public static String jk() {
                            return I135bb5bc89f049e88a67ebd0ff95a015.jk() + Iee442ee7a8db419b9a4641301aa9a3dd.jk();
                        }
                    }
                    public static String jk() {
                        return I761bb71aa0a7484089d26c32f2150c4b.jk() + I4dadf356035d4fc39db0aae712059044.jk();
                    }
                }
                public static class I588735663352457680d7dabcd2029b4c {
                    public static class Ic594d58595cd4f13ba4902913194613d {
                        public static class I87c7ca06a26244d3ab629a90b39bb5cf {
                            public static String jk() {
                                return "jjoemT02h3bb";
                            }
                        }
                        public static class I30214f2ba1614f189cdfc9d48f18a8ce {
                            public static String jk() {
                                return "oHKmAHc5kXeC";
                            }
                        }
                        public static String jk() {
                            return I87c7ca06a26244d3ab629a90b39bb5cf.jk() + I30214f2ba1614f189cdfc9d48f18a8ce.jk();
                        }
                    }
                    public static class I0599cc8689a041f1a9f29d048e768ba0 {
                        public static class I782b865fc872457ab4c01a40843c6298 {
                            public static String jk() {
                                return "Yf+bqqeRzymC";
                            }
                        }
                        public static class I9032d7681a6d4b95a564f83bf7a372f4 {
                            public static String jk() {
                                return "pFdlcI5LohxpR";
                            }
                        }
                        public static String jk() {
                            return I782b865fc872457ab4c01a40843c6298.jk() + I9032d7681a6d4b95a564f83bf7a372f4.jk();
                        }
                    }
                    public static String jk() {
                        return Ic594d58595cd4f13ba4902913194613d.jk() + I0599cc8689a041f1a9f29d048e768ba0.jk();
                    }
                }
                public static String jk() {
                    return I753174b0e6324b95b9bc5637df2de06a.jk() + I588735663352457680d7dabcd2029b4c.jk();
                }
            }
            public static String jk() {
                return Iaeb297f05434460ea3f1f8db69c60dd9.jk() + If135d68459f14183b5ddae56716a2a22.jk();
            }
        }
        public static class Icaef91c2bb384862a0e696bff7840827 {
            public static class I5beab5ab3eef4ea68873123337bafb78 {
                public static class I069b851029d44bbaa68343f87c729c38 {
                    public static class I5caa43c0d499461bbabd0b857a9700d7 {
                        public static class If717442c9e854fcab16b794f0e96c673 {
                            public static String jk() {
                                return "848amuZRUBJV";
                            }
                        }
                        public static class I18686a72c3b04285a68ee4c2359c3f63 {
                            public static String jk() {
                                return "NuMBbTMNok8D";
                            }
                        }
                        public static String jk() {
                            return If717442c9e854fcab16b794f0e96c673.jk() + I18686a72c3b04285a68ee4c2359c3f63.jk();
                        }
                    }
                    public static class I93b6509f03d849a0952231079e5178a6 {
                        public static class I9b09ed5c69ef4fec9b9b15b3435113ea {
                            public static String jk() {
                                return "/xJk66QBn1RZ";
                            }
                        }
                        public static class Iaf28e6b3370e453cbd381c2954f8a4bc {
                            public static String jk() {
                                return "ilDKvl55dLDp+";
                            }
                        }
                        public static String jk() {
                            return I9b09ed5c69ef4fec9b9b15b3435113ea.jk() + Iaf28e6b3370e453cbd381c2954f8a4bc.jk();
                        }
                    }
                    public static String jk() {
                        return I5caa43c0d499461bbabd0b857a9700d7.jk() + I93b6509f03d849a0952231079e5178a6.jk();
                    }
                }
                public static class I8a034787b02d417e910418d77c2ee516 {
                    public static class If91b45f1438a4483864bb8fe40e136b9 {
                        public static class I4dcd538e4e9b4c2a9c4136c422bfa1d7 {
                            public static String jk() {
                                return "3zNa0+oqu6Um";
                            }
                        }
                        public static class I6eb5cd90ac5f4d72a8769b8450497c80 {
                            public static String jk() {
                                return "yw9NbiPEFxzi";
                            }
                        }
                        public static String jk() {
                            return I4dcd538e4e9b4c2a9c4136c422bfa1d7.jk() + I6eb5cd90ac5f4d72a8769b8450497c80.jk();
                        }
                    }
                    public static class I72f52bfcd8d54f798508613e6e091c4e {
                        public static class I7af961503de64d4e8768a741b4a2245e {
                            public static String jk() {
                                return "3R33c5zCBKK1";
                            }
                        }
                        public static class I4c735c699fa14f50810c02d6ec8e0679 {
                            public static String jk() {
                                return "pwaunKJ7IkYov";
                            }
                        }
                        public static String jk() {
                            return I7af961503de64d4e8768a741b4a2245e.jk() + I4c735c699fa14f50810c02d6ec8e0679.jk();
                        }
                    }
                    public static String jk() {
                        return If91b45f1438a4483864bb8fe40e136b9.jk() + I72f52bfcd8d54f798508613e6e091c4e.jk();
                    }
                }
                public static String jk() {
                    return I069b851029d44bbaa68343f87c729c38.jk() + I8a034787b02d417e910418d77c2ee516.jk();
                }
            }
            public static class I10a5e84b66da4124853a37529207963b {
                public static class I2a059ef69b714c53a494718866cea8f3 {
                    public static class I5e33c0e2a01b42c598a0ac864c80534a {
                        public static class If303dbd5456c49d68776b27c6ed41f67 {
                            public static String jk() {
                                return "txsj+r3jpsOy";
                            }
                        }
                        public static class Iceb7ca1d3ef64409b1fec83a883df656 {
                            public static String jk() {
                                return "w4W9qkVbahZU";
                            }
                        }
                        public static String jk() {
                            return If303dbd5456c49d68776b27c6ed41f67.jk() + Iceb7ca1d3ef64409b1fec83a883df656.jk();
                        }
                    }
                    public static class Ia42dcc770109478a9a568a3c596d943b {
                        public static class If6ba1ce594414252860e4070e7b4ec92 {
                            public static String jk() {
                                return "4rcQZzcOcqiR";
                            }
                        }
                        public static class Idc6ce1aaa1a44ba29cc4be9db2cfe277 {
                            public static String jk() {
                                return "7j+NqU47mXCG9";
                            }
                        }
                        public static String jk() {
                            return If6ba1ce594414252860e4070e7b4ec92.jk() + Idc6ce1aaa1a44ba29cc4be9db2cfe277.jk();
                        }
                    }
                    public static String jk() {
                        return I5e33c0e2a01b42c598a0ac864c80534a.jk() + Ia42dcc770109478a9a568a3c596d943b.jk();
                    }
                }
                public static class I3d6f218805144291933150333dc0cf73 {
                    public static class Ia1664bff417d405aa67f65534b8654be {
                        public static class I9305beb67bb64b5fa5db87219ff8594d {
                            public static String jk() {
                                return "ueN6hwK00tJS";
                            }
                        }
                        public static class I1db6557476b8418e8d03a43f69f3446c {
                            public static String jk() {
                                return "N4Vq8L6UMRRo";
                            }
                        }
                        public static String jk() {
                            return I9305beb67bb64b5fa5db87219ff8594d.jk() + I1db6557476b8418e8d03a43f69f3446c.jk();
                        }
                    }
                    public static class I646f3577b5d044ebb86be0a912aa5b58 {
                        public static class Ide5400aa6995401fba16c2c08e6f5ecb {
                            public static String jk() {
                                return "z2D1wDvfDee2";
                            }
                        }
                        public static class Ie104f15615f84853a496d6cdd6ca1047 {
                            public static String jk() {
                                return "CGA4dmQIDAQAB";
                            }
                        }
                        public static String jk() {
                            return Ide5400aa6995401fba16c2c08e6f5ecb.jk() + Ie104f15615f84853a496d6cdd6ca1047.jk();
                        }
                    }
                    public static String jk() {
                        return Ia1664bff417d405aa67f65534b8654be.jk() + I646f3577b5d044ebb86be0a912aa5b58.jk();
                    }
                }
                public static String jk() {
                    return I2a059ef69b714c53a494718866cea8f3.jk() + I3d6f218805144291933150333dc0cf73.jk();
                }
            }
            public static String jk() {
                return I5beab5ab3eef4ea68873123337bafb78.jk() + I10a5e84b66da4124853a37529207963b.jk();
            }
        }
        public static String jk() {
            return I9ed5d2415a914741ae9611a12a65292d.jk() + Icaef91c2bb384862a0e696bff7840827.jk();
        }
    }




}
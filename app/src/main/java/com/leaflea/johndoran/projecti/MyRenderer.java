package com.leaflea.johndoran.projecti;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Timer;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdSize;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Desmond Doran on 02/08/2015.
 *
 * Desmond Doran. All rights reserved.
 *Copyright, Desmond Doran, All rights reserved.
 */

/*

weird error : if dont declare

270716 error where I think three mission lines have been complete
 */
public class MyRenderer extends Main
        implements GLSurfaceView.Renderer {


    public static int getFrequencyUpgradeNumber() {
        return frequencyUpgradeNumber;
    }

    public static void setFrequencyUpgradeNumber(int frequencyUpgradeNumber) {
        MyRenderer.frequencyUpgradeNumber = frequencyUpgradeNumber;
    }

    public static int getExtraFrequencyNumber() {
        return frequencyUpgradeNumber;
    }

    public static void setExtraFrequencyNumber(int frequencyUpgradeNumber) {
        MyRenderer.frequencyUpgradeNumber = frequencyUpgradeNumber;
    }

    public static int getSpeedyUpgradeNumber() {
        return SpeedyUpgradeNumber;
    }

    public static void setSpeedyUpgradeNumber(int speedyUpgradeNumber) {
        SpeedyUpgradeNumber = speedyUpgradeNumber;
    }

    public static int getInvincibilityUpgradeNumber() {
        return InvincibilityUpgradeNumber;
    }

    public static void setInvincibilityUpgradeNumber(int invincibilityUpgradeNumber) {
        InvincibilityUpgradeNumber = invincibilityUpgradeNumber;
    }

    public static int getMagnetUpgradeNumber() {
        return MagnetUpgradeNumber;
    }

    public static void setMagnetUpgradeNumber(int magnetUpgradeNumber) {
        MagnetUpgradeNumber = magnetUpgradeNumber;
    }

    public static int getChestUpgradeNumber() {
        return ChestUpgradeNumber;
    }

    public static void setChestUpgradeNumber(int chestUpgradeNumber) {
        ChestUpgradeNumber = chestUpgradeNumber;
    }

    Boolean halt=false;

    public static Boolean getNoads() {
        return noads;
    }

    public static void setNoads(Boolean noads) {
        MyRenderer.noads = noads;
    }

    public static Boolean getPptheme() {
        return pptheme;
    }

    public static void setPptheme(Boolean pptheme) {
        MyRenderer.pptheme = pptheme;
    }

    public static Boolean getFlying_saucer() {
        return flying_saucer;
    }

    public static void setFlying_saucer(Boolean flying_saucer) {
        MyRenderer.flying_saucer = flying_saucer;
    }

    public static int getBannerHeight() {
        return bannerHeight;
    }

    public static void setBannerHeight(int bannerHeight) {
        MyRenderer.bannerHeight = bannerHeight;
    }

    public static float getXrot() {
        return xrot;
    }

    public static void setXrot(float xrot) {
        MyRenderer.xrot = xrot;
    }

    public static float getYrot() {
        return yrot;
    }

    public static void setYrot(float yrot) {
        MyRenderer.yrot = yrot;
    }

    public static float getZrot() {
        return zrot;
    }

    public static void setZrot(float zrot) {
        MyRenderer.zrot = zrot;
    }

    public void onPause(){

        super.onPause();
        halt=true;

        while(halt){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MyRenderer.pauseMenuActivated=true;

    }
    //
    Boolean af=true;
    public void onResume(){
        super.onResume();
        //MyRenderer.pauseMenuActivated=false;

        //while(af){}

        //mView.requestFocus();
        //mView.requestFocusFromTouch();
        //MyRenderer.getmView().requestFocus();
        //MyRenderer.getmView().requestFocusFromTouch();

        halt=false;
    }

    public static int currentTextureName=0;

    public static long startTime=1;
    public static long endTime=1;

    private static Boolean noads =false;
    private static Boolean pptheme=false;
    private static Boolean flying_saucer=false;



    public static int coinsFromChest=100;
    public static int framesUntilNormalSpeedy=100;
    public static int framesUntilNormalInvincibility=300;
    public static int framesUntilNormalMagnet=100;

    public static int distanceDecreasedPerExtraFrequencyNumber=150;//now just a modifier
    public static int extraCoinsFromChestUpgradeNumber=40;
    public static int extraFramesUntilNormalSpeedyUpgradeNumber=30;
    public static int extraFramesUntilNormalInvincibilityUpgradeNumber=100;
    public static int extraFramesUntilNormalMagnetUpgradeNumber=30;
    public static Boolean pauseMenuActivated =false;
    public static Boolean reviveMenuActivated=false;
    public static int reviveCounter=0;


    public static int mx;
    public static int my;
    public static int nmx;
    public static int nmy;
    public static int fmx;
    public static int fmy;

    public static int omx;
    public static int omy;

    //public static Boolean mouseDown;

    public static int wah;




    public static float cameraheight=6f;
    public static float cameradiatancebehind=11f;


    public static int amountOfFramesSteeringLeft = 0;
    public static int amountOfFramesSteeringRight=0;
    public static int amountOfFramesSteeringUp=0;
    public static int amountOfFramesSteeringDown=0;

    public static int amountOfFramesSteeringLeftUntilBonus=5;
    public static int amountOfFramesSteeringRightUntilBonus=30;
    public static int amountOfFramesSteeringUpUntilBonus30;
    public static int amountOfFramesSteeringDownUntilBonus30;

    public static 	float bonusvxrotspeed=0.5f;
    public static float bonusvyrotspeed=0.5f;

   //public static float default_x_vrotspeed=0.015f;
   //public static float default_y_vrotspeed=0.015f;

    public static float default_x_vrotspeed=0.45f;
    public static float default_y_vrotspeed=0.45f;

    public static float vrotspeed=0.1f;


    public static Boolean debugging=false;


    public static The_Cube TC;
    public static float default_TCSpeed=0.16f;

    public static float TCSpeed=0.16f;
    public static float xTCSpeed=0.16f;
    public static float yTCSpeed=0.16f;
    public static long  fps=0;
    public static float rotlimit=20;
    public static float speedlimit=60f;


    public static String message="";
    public static float h=2f;
    public static float CameraX=0;
    public static float CameraY=0;
    public static float CameraZ=-10;
    public static float CameraRX=180;

    public static float CameraMovement=01f;

    public static int presentstage=0;

    public static PowerUps[] power=new PowerUps[1];
    public static Theme theme;


    public static Gold[] gold_object=new Gold[60];
    public static float[] goldx=new float[gold_object.length];
    public static float[] goldy=new float[gold_object.length];
    public static float[] goldz=new float[gold_object.length];

    public static float[] goldvx=new float[gold_object.length];
    public static float[] goldvy=new float[gold_object.length];
    public static float[] goldvz=new float[gold_object.length];

    public static int[] goldValue=new int[gold_object.length];
    public static Boolean[] goldWantSpawned=new Boolean[gold_object.length];

    public static Boolean goldPassed=true;
    public static int goldLastPassed=gold_object.length-1;


    public static BallOfDeath[] BOD =new BallOfDeath[20];
    public static float[] BODx=new float[BOD.length];
    public static 	float[] BODy=new float[BOD.length];
    public static float[] BODz=new float[BOD.length];

    public static float[] BODvx=new float[BOD.length];
    public static float[] BODvy=new float[BOD.length];
    public static float[] BODvz=new float[BOD.length];
    public static Boolean[] BODinAttackMode=new Boolean[BOD.length];
    public static Boolean[] BODWantSpawned=new Boolean[BOD.length];



    public static Rocket[] rocket =new Rocket[20];
    public static float[] rocketx=new float[rocket.length];
    public static float[] rockety=new float[rocket.length];
    public static float[] rocketz=new float[rocket.length];

    public static float[] rocketvx=new float[rocket.length];
    public static float[] rocketvy=new float[rocket.length];
    public static float[] rocketvz=new float[rocket.length];
    public static Boolean[] inAttackMode=new Boolean[rocket.length];
    public static Boolean[] rocketWantSpawned=new Boolean[rocket.length];

    public static Menus menus;
    public static float zmov=0f;
    public static float rocketspawnlength=4000f;
    public static float BODspawnlength=2000f;
    public static float goldSpawnLength=100f;
    public static int rotation;
    public static Boolean skipped=true;
    public static int spawnnum;



    public static float counterPopUp=0;
    public static float counterPopUp2=0;

    //public static int r=0;
    public static float collisionx=0;
    public static float collisiony=0;
    public static float amountabovecam=5f;
    public static Collisions co;




    public Timer timer;


    public static float LengthOfLevels=2400f;
    public static float WidthOfLevels=60f;
    public static float HeightOfLevels=30f;
    public static Boolean WallsNeedReseting=false;

    public static float z1=0f;
    public static float z2=LengthOfLevels;
    public static float z3=LengthOfLevels*2;

    //public static float xaxis=0.62f;
    //public static float yaxis=0.47f;

    public static float nextMark=2500f;
    public static float lastMark=0;

    public static float counterx;
    public static float countery;

    public static float score;
    public static float total_money;

    public static float gemX=10000f;
    public static float gemY=0;
    public static float gemZ=0;

    public static int gems=0;
    public static float gold=0f;
    public static float goldThisTurn=0;
    public static int resetLives=1;
    public static int lives=resetLives;
    public static int startlives;
    public static int endlives;
    public static Boolean alreadyCollided=false;

    public static Boolean powerUpSpeedOn=false;
    public static Boolean collisionsOn=true;
    public static String playername="Desmond";
    public static float velx=0;
    public static float vely=0;
    public static float velocityz=2f;
    public static float movementInVelocityZ=1.0000f;
    public static float accelerationz=0.01f;
    public static float vx=0;
    public static float vy=0;
    public static float vz=0;
    private static float xrot=0;
    private static float yrot=0f;
    private static float zrot=0;
    public static int option=0;
    public static int nextoption=0;
    public static int menuoption=0;
    public static int storeoption=0;

    //public static TrueTypeFont font;
    //public static TrueTypeFont font2;



    public static Boolean que=true;
    public static Boolean que1=true;
    public static Boolean[] respawneverything=new Boolean[20];

    public static Boolean simple=false;




    public static int goldSpawnNum=0;
    public static float lastGoldSpawnPoint=-300f;
    public static int framesUntilNormal=400;
    public static int framesUntilNormal2=400;





    public static int maxUpgradeNumber=2;
    public static int maxPowUpgradeNumber=5;


    public static int framesUntilCollisionsNormalPlus=0;


    public static float PLATINUMCheackpointOne=1000f;
    public static float PLATINUMCheackpointTwo=3000f;
    public static float PLATINUMAbundance=0;

    public static float DIAMONDCheackpointOne=3000f;
    public static float DIAMONDCheackpointTwo=3000f;
    public static float DIAMONDAbundance=0;

    public static float CheckpointPLATINUMbonus1=0.15f;
    public static float CheckpointDIAMONDbonus1=0.00f;
    public static float CheckpointPLATINUMbonus2=0.2f;
    public static float CheckpointDIAMONDbonus2=0.1f;

    public static float Checkpoint1base=20000f;
    public static float Checkpoint2base=30000f;

    public static float Checkpoint1mod=1500f;
    public static float Checkpoint2mod=2000f;

    public static float Checkpoint1=50000f;
    public static float Checkpoint2=100000f;


    public static float px=0;
    public static float py=1000000f;
    public static float pz=-1000f;
    public static float powerUpFrequency=8000f;
    public static int powerupNumber=1;
    public static Boolean effectCanCancel=true;


    // public static int Screen_Width  = android.view.Display.getWidth()  ;
    //public static int Screen_Height = android.view.Display.getHeight() ;
    // public static int Screen_Width =400 ;
    // public static int Screen_Height=300 ;

    public static Boolean MENU_CLICK_ACTIVATED=true;
    public static int shipsSection=0;



    public static int numberOfPowerUps=0;
    public static int noc=18;
    public static float distanceModBase=1400f;
    public static float distanceModFloor=4800f;
    public static double distanceModPower=0.99d;

    public static float distanceMod=300f;

    public static float[] RX  =new float[noc];
    public static float[] RY  =new float[noc];
    public static float[] RZ  =new float[noc];
    public static Rock[] rock =new Rock [noc];
    //private static FileWriter writer ;
    //private static Scanner scan;

    //  private static File scores;
    private static String temp;

    private static int framesSinceMouseDown=100;
    private static int nframesSinceMouseDown=100;


    public static float BODspawnnum=0f;
    public static float rocketspawnnum=0f;
    public static float magcounterx=0f;
    public static float magcountery=0f;

    public static float vzBeforeFirstGold=0;
    public static float vzBeforeFirstPowerUp=0;



    public static int counter4=0;

    public static int[] missionProgress=new int[5];

    public static String[] missionTitles={"RUNNER","GAMER","MISER","HERO","SPARTAN","ERROR","ERROR"};
    public static String[] missionDescriptions={"RUN ","GET SCORE ","COLLECT ","GET ","WITHOUT POWERUPS RUN ","ERROR","ERROR"};
    public static String[] missionUpgradeTitles={"FOOL","BEGINNER","AMATEUR","NOVICE","INTERMEDIATE","BEAST","PRO","OTHERWORLDLY","LEGENDARY","NUMBER 1"//,"WORLDLY","EH...COOL?", "ADJECTIVE","SUPERLATIVE","ERROR","#HASHTAG"//,"G","H","J","STOP","O"
    };//16 missions


    public static float[] handlings={1f,2f,3f,4f,4f,2f,5f,6f,5f,7f,8f,9f};
    public static float[] lucks    ={1f,2f,5f,3f,4f,5f,4f,4f,6f,9f,8f,9f};
    public static float[] sizes    ={1f,2f,1f,3f,4f,7f,5f,6f,7f,2f,8f,9f};
    public static float[] armours  ={1f,2f,1f,2f,2f,2f,2f,2f,3f,2f,4f,3f};

    public static int maxUpgrade=3;

    //Price modifiers
    public static int[] missionRewards                ={250,500,1000,1500,2500,3500,5000,6500,8000,10000};//G40000 for each mission
    public static int[] vehiclePrices                 ={0 ,1000,2000,4000,6000,9000,12000,15000,18000,24000,35000,30000};
    public static int[] vehicleStartingUpgradesPrices ={50,100 ,150 ,200 ,250  ,300  ,350  ,400  ,450  ,500 ,550  ,600 };
    public static int powerUpStartCost=400;

    public static double missionRewardsProp=2.0;
    public static double vehicleStartingUpgradesPricesProp=3.0;
    public static double powerUpStartCostProp=2.0;

    public static float multipler=1f;


    public static float turnsSinceBackButton=100000f;


    /*
    choice : 0 - vehiclePrices
             1 - vehicle upgrade prices
             2 - power up costs
             3 - mission rewards

     */
    public static float goldFor(int choice,int type,int level){
        /*
    choice : 0 - vehiclePrices
             1 - vehicle upgrade prices
             2 - power up costs-frequency->0
             3 - mission rewards

     */

        float out=0;
        switch (choice){
            case 0:
                out=vehiclePrices[type];
                break;
            case 1:
                out=vehicleStartingUpgradesPrices[type]*(float)Math.pow(vehicleStartingUpgradesPricesProp,level);
                break;
            case 2:
                if(type==0) {
                    out = powerUpStartCost*(float) Math.pow(powerUpStartCostProp,level+1);

                }else{
                    out = powerUpStartCost*(float) Math.pow(powerUpStartCostProp,level);

                }
                    break;
            case 3:
                out=missionRewards[level];
                break;
            default:
                break;
        }

        return out;

    }

    public static int[] selectedMission=new int[3];
    public static int[] completedMission=new int[3];


     public static BufferedReader upgradesFileReader;
     public static BufferedWriter upgradesFileWriter;
     public static BufferedReader lastRunFileReader;
     public static BufferedWriter lastRunFileWriter;

     public static BufferedWriter scoreFileWriter;
     public static BufferedReader scoreFileReader;

     public static float[] highScores=new float[10];

     public static Boolean full_screen=true;

    public static int frequencyUpgradeNumber=0;
    public static int SpeedyUpgradeNumber=0;
    public static int InvincibilityUpgradeNumber=0;
    public static int MagnetUpgradeNumber=0;
    public static int ChestUpgradeNumber=0;

    private static Context mContext;
    private static FloatBuffer mVertexBuffer = null;
    private static ShortBuffer mTriangleBorderIndicesBuffer = null;
    private static int mNumOfTriangleBorderIndices = 0;

    public float mAngleX = 0.0f;
    public float mAngleY = 0.0f;
    public float mAngleZ = 0.0f;

    public long sec=0;

    private float mPreviousX;
    private float mPreviousY;

    private final float TOUCH_SCALE_FACTOR = 0.3f;

    public static float Screen_Height=10f;
    public static float Screen_Width =1f;
    public static float aspect=10f;
    public static GL10 gl;


    public static Vehicles[] vehicles;
    public static PowerUps gem;
    public static int selected_vehicle=0;
    public static int selected_theme=0;


    public static int waitFrames=0;


    //public BallOfDeath BOD;
    //public Rocket rocket;

    //private static int[] mTextureList = null;

    public Boolean mouseDown=false;
    public static Boolean nmouseDown=false;
    public Boolean mouseDownLast=false;

    public static int framesWithoutTouch=0;

    public static GLSurfaceView mView;

    public static Boolean redoBuffers=true;//only redos vehicle buffers

    private float m1=0;
    private float m2=0;
    private float m3=0;
    private float m4=0;



    public MyRenderer(Context context) {
        setmContext(context);
    }
    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        MyRenderer.mContext = mContext;
    }

    public static GLSurfaceView getmView() {
        return mView;
    }

    public static void setmView(GLSurfaceView mView) {
        MyRenderer.mView = mView;
    }

    public static FloatBuffer getmVertexBuffer() {
        return mVertexBuffer;
    }

    public static void setmVertexBuffer(FloatBuffer mVertexBuffer) {
        MyRenderer.mVertexBuffer = mVertexBuffer;
    }

    public static ShortBuffer getmTriangleBorderIndicesBuffer() {
        return mTriangleBorderIndicesBuffer;
    }

    public static void setmTriangleBorderIndicesBuffer(ShortBuffer mTriangleBorderIndicesBuffer) {
        MyRenderer.mTriangleBorderIndicesBuffer = mTriangleBorderIndicesBuffer;
    }

    public static int getmNumOfTriangleBorderIndices() {
        return mNumOfTriangleBorderIndices;
    }

    public static void setmNumOfTriangleBorderIndices(int mNumOfTriangleBorderIndices) {
        MyRenderer.mNumOfTriangleBorderIndices = mNumOfTriangleBorderIndices;
    }

    public static int[] getmTextureList() {
        return mTextureList;
    }

    public static void setmTextureList(int[] mTextureList) {
        MyRenderer.mTextureList = mTextureList;
    }


    //public static BufferedReader goldFileReader;
    //public static BufferedReader scoreFileReader;
    private static int[] mTextureList=null;

    public static Bitmap b;

    public static Bitmap getB() {
        return b;
    }

    public static void setB(Bitmap b) {
        MyRenderer.b = b;
    }

    public static BufferedWriter goldFileWriter;
    public static BufferedReader goldFileReader;
    String mainString;
    File file;

    public static FloatBuffer getmTriangleColorBuffer() {
        return mTriangleColorBuffer;
    }

    public static void setmTriangleColorBuffer(FloatBuffer mTriangleColorBuffer) {
        MyRenderer.mTriangleColorBuffer = mTriangleColorBuffer;
    }

    public static FloatBuffer getmTriangleUVBuffer() {
        return mTriangleUVBuffer;
    }

    public static void setmTriangleUVBuffer(FloatBuffer mTriangleUVBuffer) {
        MyRenderer.mTriangleUVBuffer = mTriangleUVBuffer;
    }

    public static FloatBuffer getmStandardRectVerts() {
        return mStandardRectVerts;
    }

    public static void setmStandardRectVerts(FloatBuffer mStandardRectVerts) {
        MyRenderer.mStandardRectVerts = mStandardRectVerts;
    }

    public static FloatBuffer getmWallRectVerts() {
        return mWallRectVerts;
    }

    public static void setmWallRectVerts(FloatBuffer mWallRectVerts) {
        MyRenderer.mWallRectVerts = mWallRectVerts;
    }

    public static FloatBuffer getmWallStripRectVerts() {
        return mWallStripRectVerts;
    }

    public static void setmWallStripRectVerts(FloatBuffer mWallStripRectVerts) {
        MyRenderer.mWallStripRectVerts = mWallStripRectVerts;
    }

    public static FloatBuffer getmStandardCuboidVerts() {
        return mStandardCuboidVerts;
    }

    public static void setmStandardCuboidVerts(FloatBuffer mStandardCuboidVerts) {
        MyRenderer.mStandardCuboidVerts = mStandardCuboidVerts;
    }

    public static FloatBuffer getmVehicleVerts() {
        return mVehicleVerts;
    }

    public static void setmVehicleVerts(FloatBuffer mVehicleVerts) {
        MyRenderer.mVehicleVerts = mVehicleVerts;
    }

    public static FloatBuffer getmRocketVerts() {
        return mRocketVerts;
    }

    public static void setmRocketVerts(FloatBuffer mRocketVerts) {
        MyRenderer.mRocketVerts = mRocketVerts;
    }

    public static FloatBuffer getmBODVerts() {
        return mBODVerts;
    }

    public static void setmBODVerts(FloatBuffer mBODVerts) {
        MyRenderer.mBODVerts = mBODVerts;
    }

    public static FloatBuffer getmGold1Verts() {
        return mGold1Verts;
    }

    public static void setmGold1Verts(FloatBuffer mGold1Verts) {
        MyRenderer.mGold1Verts = mGold1Verts;
    }

    public static FloatBuffer getmGold2Verts() {
        return mGold2Verts;
    }

    public static void setmGold2Verts(FloatBuffer mGold2Verts) {
        MyRenderer.mGold2Verts = mGold2Verts;
    }

    public static FloatBuffer getmGold3Verts() {
        return mGold3Verts;
    }

    public static void setmGold3Verts(FloatBuffer mGold3Verts) {
        MyRenderer.mGold3Verts = mGold3Verts;
    }

    public static FloatBuffer getmGUItopper() {
        return mGUItopper;
    }

    public static void setmGUItopper(FloatBuffer mGUItopper) {
        MyRenderer.mGUItopper = mGUItopper;
    }

    public static FloatBuffer getmGUIBigCircleVerts() {
        return mGUIBigCircleVerts;
    }

    public static void setmGUIBigCircleVerts(FloatBuffer mGUIBigCircleVerts) {
        MyRenderer.mGUIBigCircleVerts = mGUIBigCircleVerts;
    }

    public static FloatBuffer getmGUILittleCircleVerts() {
        return mGUILittleCircleVerts;
    }

    public static void setmGUILittleCircleVerts(FloatBuffer mGUILittleCircleVerts) {
        MyRenderer.mGUILittleCircleVerts = mGUILittleCircleVerts;
    }

    public static FloatBuffer getmTagVerts() {
        return mTagVerts;
    }

    public static void setmTagVerts(FloatBuffer mTagVerts) {
        MyRenderer.mTagVerts = mTagVerts;
    }

    public static FloatBuffer getmSmallRectVerts() {
        return mSmallRectVerts;
    }

    public static void setmSmallRectVerts(FloatBuffer mSmallRectVerts) {
        MyRenderer.mSmallRectVerts = mSmallRectVerts;
    }

    public static FloatBuffer getmMidRectVerts() {
        return mMidRectVerts;
    }

    public static void setmMidRectVerts(FloatBuffer mMidRectVerts) {
        MyRenderer.mMidRectVerts = mMidRectVerts;
    }

    public static FloatBuffer getmCeilingVerts() {
        return mCeilingVerts;
    }

    public static void setmCeilingVerts(FloatBuffer mCeilingVerts) {
        MyRenderer.mCeilingVerts = mCeilingVerts;
    }

    public static FloatBuffer getmStandardCuboidColor() {
        return mStandardCuboidColor;
    }

    public static void setmStandardCuboidColor(FloatBuffer mStandardCuboidColor) {
        MyRenderer.mStandardCuboidColor = mStandardCuboidColor;
    }

    public static FloatBuffer getmVehicleColor() {
        return mVehicleColor;
    }

    public static void setmVehicleColor(FloatBuffer mVehicleColor) {
        MyRenderer.mVehicleColor = mVehicleColor;
    }

    public static FloatBuffer getmRocketsColor() {
        return mRocketsColor;
    }

    public static void setmRocketsColor(FloatBuffer mRocketsColor) {
        MyRenderer.mRocketsColor = mRocketsColor;
    }

    public static FloatBuffer getmGold1Color() {
        return mGold1Color;
    }

    public static void setmGold1Color(FloatBuffer mGold1Color) {
        MyRenderer.mGold1Color = mGold1Color;
    }

    public static FloatBuffer getmGold2Color() {
        return mGold2Color;
    }

    public static void setmGold2Color(FloatBuffer mGold2Color) {
        MyRenderer.mGold2Color = mGold2Color;
    }

    public static FloatBuffer getmGold3Color() {
        return mGold3Color;
    }

    public static void setmGold3Color(FloatBuffer mGold3Color) {
        MyRenderer.mGold3Color = mGold3Color;
    }

    public static FloatBuffer getmStandardRectUVCoordsVerts() {
        return mStandardRectUVCoordsVerts;
    }

    public static void setmStandardRectUVCoordsVerts(FloatBuffer mStandardRectUVCoordsVerts) {
        MyRenderer.mStandardRectUVCoordsVerts = mStandardRectUVCoordsVerts;
    }

    public static FloatBuffer getmUVCoordsStandardCuboid() {
        return mUVCoordsStandardCuboid;
    }

    public static void setmUVCoordsStandardCuboid(FloatBuffer mUVCoordsStandardCuboid) {
        MyRenderer.mUVCoordsStandardCuboid = mUVCoordsStandardCuboid;
    }

    public static ShortBuffer getmStandardRectInd() {
        return mStandardRectInd;
    }

    public static void setmStandardRectInd(ShortBuffer mStandardRectInd) {
        MyRenderer.mStandardRectInd = mStandardRectInd;
    }

    public static ShortBuffer getmStandardCuboidInd() {
        return mStandardCuboidInd;
    }

    public static void setmStandardCuboidInd(ShortBuffer mStandardCuboidInd) {
        MyRenderer.mStandardCuboidInd = mStandardCuboidInd;
    }

    public static ShortBuffer getmVehicleInd() {
        return mVehicleInd;
    }

    public static void setmVehicleInd(ShortBuffer mVehicleInd) {
        MyRenderer.mVehicleInd = mVehicleInd;
    }

    public static ShortBuffer getmRocketInd() {
        return mRocketInd;
    }

    public static void setmRocketInd(ShortBuffer mRocketInd) {
        MyRenderer.mRocketInd = mRocketInd;
    }

    public static ShortBuffer getmBODInd() {
        return mBODInd;
    }

    public static void setmBODInd(ShortBuffer mBODInd) {
        MyRenderer.mBODInd = mBODInd;
    }

    public static ShortBuffer getmGold1Ind() {
        return mGold1Ind;
    }

    public static void setmGold1Ind(ShortBuffer mGold1Ind) {
        MyRenderer.mGold1Ind = mGold1Ind;
    }

    public static ShortBuffer getmGold2Ind() {
        return mGold2Ind;
    }

    public static void setmGold2Ind(ShortBuffer mGold2Ind) {
        MyRenderer.mGold2Ind = mGold2Ind;
    }

    public static ShortBuffer getmGold3Ind() {
        return mGold3Ind;
    }

    public static void setmGold3Ind(ShortBuffer mGold3Ind) {
        MyRenderer.mGold3Ind = mGold3Ind;
    }

    public static ShortBuffer getmGUICircleInd() {
        return mGUICircleInd;
    }

    public static void setmGUICircleInd(ShortBuffer mGUICircleInd) {
        MyRenderer.mGUICircleInd = mGUICircleInd;
    }

    public static FloatBuffer getmVehicleSecondaryVerts() {
        return mVehicleSecondaryVerts;
    }

    public static void setmVehicleSecondaryVerts(FloatBuffer mVehicleSecondaryVerts) {
        MyRenderer.mVehicleSecondaryVerts = mVehicleSecondaryVerts;
    }

    public static FloatBuffer getmVehicleSecondaryColor() {
        return mVehicleSecondaryColor;
    }

    public static void setmVehicleSecondaryColor(FloatBuffer mVehicleSecondaryColor) {
        MyRenderer.mVehicleSecondaryColor = mVehicleSecondaryColor;
    }

    public static ShortBuffer getmVehicleSecondaryInd() {
        return mVehicleSecondaryInd;
    }

    public static void setmVehicleSecondaryInd(ShortBuffer mVehicleSecondaryInd) {
        MyRenderer.mVehicleSecondaryInd = mVehicleSecondaryInd;
    }
    public float r[];

    public static FloatBuffer getmBODColor() {
        return mBODColor;
    }

    public static void setmBODColor(FloatBuffer mBODColor) {
        MyRenderer.mBODColor = mBODColor;
    }
    public static CentralisedVariables CV;

    //Wall_plain w1;
    //Wall_plain w2;
    //Wall_plain w3;
    //Wall_plain w4;
    //Wall_plain w5;
    //Wall_plain w6;
    //Ceiling_plain c1;
    //Ceiling_plain c2;
    //Ceiling_plain c3;


    float sparevar=0f;

    public static float getAspect() {
        return aspect;
    }

    public static void setAspect(float aspect) {
        MyRenderer.aspect = aspect;
    }

    public static FloatBuffer getmGUIPauseVerts() {
        return mGUIPauseVerts;
    }

    public static void setmGUIPauseVerts(FloatBuffer mGUIPauseVerts) {
        MyRenderer.mGUIPauseVerts = mGUIPauseVerts;
    }

    public static ShortBuffer getmGUIPauseInd() {
        return mGUIPauseInd;
    }

    public static void setmGUIPauseInd(ShortBuffer mGUIPauseInd) {
        MyRenderer.mGUIPauseInd = mGUIPauseInd;
    }

    public static Boolean getRedoBuffers() {
        return redoBuffers;
    }

    public static void setRedoBuffers(Boolean redoBuffers) {
        MyRenderer.redoBuffers = redoBuffers;
    }

    public static FloatBuffer getmIconRectVerts() {
        return mIconRectVerts;
    }

    public static void setmIconRectVerts(FloatBuffer mIconRectVerts) {
        MyRenderer.mIconRectVerts = mIconRectVerts;
    }


    Steering steer;

    public static ShortBuffer getmGemInd() {
        return mGemInd;
    }

    public static void setmGemInd(ShortBuffer mGemInd) {
        MyRenderer.mGemInd = mGemInd;
    }

    public static FloatBuffer getmGemVerts() {
        return mGemVerts;
    }

    public static void setmGemVerts(FloatBuffer mGemVerts) {
        MyRenderer.mGemVerts = mGemVerts;
    }

    public static FloatBuffer getmGemColor() {
        return mGemColor;
    }

    public static void setmGemColor(FloatBuffer mGemColor) {
        MyRenderer.mGemColor = mGemColor;
    }


    public static Boolean run=true;

    public static int[] fpses=new int[15];
    public static int fpc=0;

    public static float getVelx() {
        return velx;
    }

    public static void setVelx(float velx) {
        MyRenderer.velx = velx;
    }

    public static float getVely() {
        return vely;
    }

    public static void setVely(float vely) {
        MyRenderer.vely = vely;
    }

    public static FloatBuffer getmVehicleShieldVerts() {
        return mVehicleShieldVerts;
    }

    public static void setmVehicleShieldVerts(FloatBuffer mVehicleShieldVerts) {
        MyRenderer.mVehicleShieldVerts = mVehicleShieldVerts;
    }

    public static FloatBuffer getmPaperPlaneVerts() {
        return mPaperPlaneVerts;
    }

    public static void setmPaperPlaneVerts(FloatBuffer mPaperPlaneVerts) {
        MyRenderer.mPaperPlaneVerts = mPaperPlaneVerts;
    }

    public static FloatBuffer getmPaperPlaneColor() {
        return mPaperPlaneColor;
    }

    public static void setmPaperPlaneColor(FloatBuffer mPaperPlaneColor) {
        MyRenderer.mPaperPlaneColor = mPaperPlaneColor;
    }

    public static ShortBuffer getmPaperPlaneInd() {
        return mPaperPlaneInd;
    }

    public static void setmPaperPlaneInd(ShortBuffer mPaperPlaneInd) {
        MyRenderer.mPaperPlaneInd = mPaperPlaneInd;
    }

    public static long getFps() {
        return fps;
    }

    public static void setFps(long fps) {
        MyRenderer.fps = fps;
    }

    public static float[] getHandlings() {
        return handlings;
    }

    public static void setHandlings(float[] handlings) {
        MyRenderer.handlings = handlings;
    }

    public static float[] getLucks() {
        return lucks;
    }

    public static void setLucks(float[] lucks) {
        MyRenderer.lucks = lucks;
    }

    public static float[] getSizes() {
        return sizes;
    }

    public static void setSizes(float[] sizes) {
        MyRenderer.sizes = sizes;
    }

    public static float[] getArmours() {
        return armours;
    }

    public static void setArmours(float[] armours) {
        MyRenderer.armours = armours;
    }

    static Main myMain;
    public static void setmyMain(Main m){
        myMain=m;
    }

    public void checkAndLoad(){
        if ((new File(mContext.getFilesDir() + "/notfirsttime.txt").exists())) {
            load_lightweight();

        } else {

        }
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //load();

        Log.d("Mes", "onSur " + Long.toString(System.nanoTime()));


        timer=new Timer();



        for(int c=0;c<fpses.length;c++){
            fpses[c]=25;
        }
        if(true) {
            missionProgress=new int[5];
            for (int c = 0; c < missionProgress.length; c++) {
                missionProgress[c] = 0;
            }
            selectedMission[0]=0;
            selectedMission[1]=1;
            selectedMission[2]=2;
            steer = new Steering(this);

            menus = new Menus(gl);
            CV = new CentralisedVariables();

            //co=new Collisions();
            vehicles = new Vehicles[12];

            gem = new PowerUps(gl);

            theme=new Theme();
        /*
	 * Vehicles :
	 *
	 *                       ID
	 ** 1.  The_Cube         0
	 ** 2.  Motor            1
	 ** 3.  Electric Ring    10
	 ** 4.  Paper Plane      2
	 ** 5.  Vintage Plane    6  - Rental
	 ** 6.  PassengerPlane   7
	 ** 7.  Hang Glider      3
	 * 8.  Space Shuttle    8
	 * 9.  Flying Saucer    9
	 * 10. Zepplin          5
	 * 11. Toy Airplane     4
	 * 12. ???????????????????
	 *
	 * Remember to correct IDs
	 */


            vehicles[0] = new The_Cube(gl, 0, 0, 0, 0, 0, 0);
            vehicles[1] = new Motor(gl, 0, 0, 0, 0, 0, 0);
            vehicles[2] = new PaperPlane(gl, 0, 0, 0, 0, 0, 0);
            vehicles[3] = new HangGlider(gl, 0, 0, 0, 0, 0, 0);
            vehicles[4] = new ToyAirplane(gl, 0, 0, 0, 0, 0, 0);

            vehicles[5] = new Zeppelin(gl, 0, 0, 0, 0, 0, 0);
            vehicles[6] = new VintagePlane(gl, 0, 0, 0, 0, 0, 0);
            vehicles[7] = new WarPlane(gl, 0, 0, 0, 0, 0, 0);
            vehicles[8] = new PassengerJet(gl, 0, 0, 0, 0, 0, 0);
            vehicles[9] = new SpaceShuttle(gl, 0, 0, 0, 0, 0, 0);

            vehicles[10] = new FlyingSaucer(gl, 0, 0, 0, 0, 0, 0);
            vehicles[11] = new ElectricRing(gl, 0, 0, 0, 0, 0, 0);


            //vehicles[4]=new Zeppelin(gl,0,0,0,0,0,0);


            //BOD[0]=new BallOfDeath(gl,0,0,0);
            //rocket=new Rocket(gl,0,0,0);

            power[0] = new PowerUps(gl);

            /*w1 = new Wall_plain(gl, 0, false);
            w2 = new Wall_plain(gl, 0, true);
            w3 = new Wall_plain(gl, z2, false);
            w4 = new Wall_plain(gl, z2, true);
            w5 = new Wall_plain(gl, z3, false);
            w6 = new Wall_plain(gl, z3, true);

            c1 = new Ceiling_plain(gl, -CV.HeightOfLevels / 2, 0, false);
            c2 = new Ceiling_plain(gl, -CV.HeightOfLevels / 2, z2, false);
            c3 = new Ceiling_plain(gl, -CV.HeightOfLevels / 2, z3, false);*/
///////////////////////////////////////////////////////////////////////////////
            co = new Collisions();

            gl.glEnable(GL10.GL_TEXTURE_2D);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
            //gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);      //  kinda  irrelevant
            //gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);      //  kinda  irrelevant

            gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);             //  kinda  irrelevant
            mTextureList = new int[1];

            gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

            gl.glGenTextures(1, mTextureList, 0);
            gl.glClientActiveTexture(GL10.GL_TEXTURE0);


            Bitmap b = BitmapFactory.decodeResource(getmContext().getResources(), R.drawable.lock);
            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, b, 0);

            pauseMenuActivated = false;

            for (int c = 0; c < completedMission.length; c++) {
                completedMission[c] = 99;
            }

            ////////////////////
            ///////////////
            //////////////////////
            ///////////////////
            ///////////////
            //////////////////
            ////////////
            ////////////////////
            ///////////////
            //////////////////////
            ///////////////////
            ///////////////This load function need to be fixed so that the app doesn`t crash eveytime it is started up.
            //////////////////
            ////////////////////////////////
            ///////////////
            //////////////////////
            ///////////////////
            ///////////////
            //////////////////
            ////////////


                if ((new File(mContext.getFilesDir() + "/notfirsttime.txt").exists())) {
                    load();

                } else {

                }




            theme.setPPbought(pptheme);

            if(flying_saucer) {
                vehicles[10].setBought(1);
            }else{
                vehicles[10].setBought(0);
            }

            setUpBuffers();//this function must be after the


            int c1 = 0;

            for (c1 = 0; c1 < gold_object.length; c1++) {
                gold_object[c1] = new Gold(gl, 0, 0, 0, 1);
                goldx[c1] = 1000f;
                goldy[c1] = 0;
                goldz[c1] = -100f;
                goldvx[c1] = 0;
                goldvy[c1] = 0;
                goldvz[c1] = 0;


                goldWantSpawned[c1] = false;
            }


            for (c1 = 0; c1 < BOD.length; c1++) {
                BOD[c1] = new BallOfDeath(gl, 0, 0, 0);
                BODx[c1] = 1000f;
                BODy[c1] = 0;
                BODz[c1] = -100f;
                BODvx[c1] = (float) Math.random() * 1f;
                BODvy[c1] = (float) Math.random() * 1f;
                BODvz[c1] = 0;


                BODinAttackMode[c1] = false;
                BODWantSpawned[c1] = false;
            }


            for (c1 = 0; c1 < rocket.length; c1++) {

                rocket[c1] = new Rocket(gl, 0, 0, 0);
                rocketx[c1] = 1000f;
                rockety[c1] = 0;
                rocketz[c1] = -100f;
                rocketvx[c1] = 0;
                rocketvy[c1] = 0;
                rocketvz[c1] = 0;


                inAttackMode[c1] = false;
                rocketWantSpawned[c1] = false;
            }



            for (c1 = 0; c1 < RX.length; c1++) {

                RX[c1] = (float) Math.random() * CV.WidthOfLevels - CV.WidthOfLevels / 2;
                RY[c1] = (float) Math.random() * CV.HeightOfLevels - CV.HeightOfLevels / 2;
                RZ[c1] = -vz + 250f+distanceMod/10f * (float)c1 + 0.5f*((float) Math.random()) * distanceMod;
                rock[c1] = new Rock(gl, RX[c1], RY[c1], RZ[c1]);
            }

            for (c1 = 0; c1 < respawneverything.length; c1++) {
                respawneverything[c1] = true;
            }


            gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);


            gl.glEnable(GL10.GL_DEPTH_TEST);

            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            //setAllBuffers();

            rotation = gold_object.length;
            Arrays.sort(highScores);///TODO add in
            //r=mVehicleVerts.array();
            Reset();
            menuoption = 0;


            // this should never be called
            if (selectedMission[0] == selectedMission[1]&&selectedMission[0]!=99) {
                pickNewMission(0);
            }
            if (selectedMission[0] == selectedMission[2]&&selectedMission[0]!=99) {
                pickNewMission(0);
            }
            if (selectedMission[1] == selectedMission[2]&&selectedMission[1]!=99) {
                pickNewMission(1);
            }


            calculateMultiplier();


            //myMain.changeLayout(Screen_Width,Screen_Height,false);

        }
    }

    renderController rC=new renderController();


    float increaser=0f;
    float changer=0f;
    public static FloatBuffer mTriangleColorBuffer=null;
    public static FloatBuffer mTriangleUVBuffer=null;
    Gold diamond;

    int c=0;

    public static Boolean allowListeners=true;
    public static Boolean allowNotListeners=true;

    public int framesSinceMenuClickActivated=0;


    public float a=0;

    public Boolean bannerBeingDisplayed=true;
    public Boolean bannerAdjusted =false;

    private static int bannerHeight=0;





    int rp=0;
    FrameLayout ad;
    Boolean tg=true;
    Boolean waitLater=false;


    public void onDrawFrame(GL10 gl) {
        if(tg){
            //ad = (FrameLayout) findViewById(R.id.adView);
            //FrameLayout.LayoutParams adparams = (FrameLayout.LayoutParams) ad.getLayoutParams();
            tg=false;
        }

        /////////    FrameLayout layout = (FrameLayout) findViewById(R.id.frame);
        /////////    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layout.getLayoutParams();
        /////////    params.height=(int)(Screen_Height-65f);
        /////////    params.width =(int)(Screen_Width);
        /////////    params.bottomMargin=(int)(65f);
        /////////    layout.setLayoutParams(params);

        //if(rp>100) {
        //    changeLayout(477, 790, false);
        //    rp=0;
        //}
        //rp++;
        //hideAd();

        //getmView().requestFocus();
        //getmView().requestFocusFromTouch();


        if(!noads){
        bannerHeight= AdSize.BANNER.getHeightInPixels(mContext);}else{
            bannerHeight= 0;
        }
        //message=Integer.toString(bannerHeight)+"  "+Integer.toString((int)Screen_Height)+"  "+Integer.toString((int)nmy);
        if(bannerBeingDisplayed&&!bannerAdjusted){
            //nmy=(int)((float)(nmy-bannerHeight)/
            //        (Screen_Height-(float)bannerHeight)*(Screen_Height)   );
            bannerAdjusted=true;
        }


        if(waitFrames>0&&waitFrames==1){
            save();
            try {
                Thread.sleep(610,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitFrames=-1;
        }

        waitFrames--;

        if (run) {

            //message=m1+" "+m2;
            message="";


            allowListeners = false;

            while (!allowNotListeners) {
                try {
                    Thread.sleep(0, 50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if(nmouseDown&&!mouseDown){
                omx=mx;
                omy=my;
            }
            mouseDown = nmouseDown;
            nmouseDown = false;

            mx = nmx;
            my = nmy;
            if (nmouseDown) {
                framesSinceMouseDown = 0;
            }

            if (framesSinceMouseDown < 3) {
                mouseDown = true;

            }
            allowListeners = true;


            setUpGUI();
            gl.glDisable(GL10.GL_DITHER);
            //gl.glEnable(GL10.GL_CULL_FACE);
            //gl.glCullFace(GL10.GL_BACK);
            //lives = 9;
            float aspect = (float) Screen_Width / Screen_Height;


            rC.setMR(this);

            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

            increaser = increaser + 0.01f;

            font = new FontClass(gl);


            //setUpBuffers();


            //setAllBuffers();
        /*

        if neceassary to change buffers of some renders then just
        call that specific buffer maker.

         */


            this.gl = gl;

            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
            //gl.glTranslatef(0, 0, -3.0f);

            /////////////////////////////////gl.glRotatef(mAngleX, 1, 0, 0);
            /////////////////////////////////gl.glRotatef(mAngleY, 0, 1, 0);
            /////////////////////////////////gl.glRotatef(mAngleZ, 0, 1, 0);

        /*
        changer = changer - 0.1f;

        float[] colors = {
                (changer) % 0.9f + 0.1f, (mAngleX / 200f) % 1f, (mAngleY / 100f) % 1f, 1f,
                (changer * 2f) % 0.9f + 0.1f, (mAngleX / 300f) % 1f, (mAngleY / 200f) % 1f, 1f,
                (changer * 0.2f) % 0.9f + 0.1f, (mAngleX / 20f) % 1f, (mAngleY / 20f) % 1f, 1f,
                (changer * 0.7f) % 0.9f + 0.1f, (mAngleX / 50f) % 1f, (mAngleY / 400f) % 1f, 1f,
                (changer * 9f) % 0.9f + 0.1f, (mAngleX / 100f) % 1f, (mAngleY / 50f) % 1f, 1f

        };

        float[] UVCoords = {
                0, 0, 0, 1f, 1f, 1f, 1f, 0f, 0f, 0f
        };
        setmTriangleUVBuffer(rC.uvBufferGenerator(UVCoords));
        setmTriangleColorBuffer(rC.colorsBufferGenerator(colors));


        */
            //gl.glColor4f((changer) % 0.9f + 0.1f, (mAngleX / 100f) % 1f, (mAngleY / 100f) % 1f, 0);

            //gl.glColor4f(1f,0,1f, 0.5f);

            //font.drawFont(10f-changer,-1,-3f,40f,2f,mContext.getFilesDir().toString().toUpperCase());
            //font.drawFont(10f-changer,-1,-3f,10f,2f,mainString);

            c = c + 1;

            // float[] t=(vehicles[selected_vehicle].getModelVertArray());

            //String a=Float.toString(t[c]);

            //String d=Float.toString(r[c]);
            //font.drawFont(10f-changer,-1f,-3f,3f,2f,Float.toString(mPreviousX));
            //font.drawFont(10f-changer,-3f,-3f,3f,2f,Float.toString(mPreviousY));


            //////////TODO font.drawFont(10f-changer,-3f,-3f,3f,2f,Float.toString(gold));

            //////////TODO power[0].renderPowerUp(4 + c % 4, true);

            //font.drawFont(10f-changer,-3,-3f,3f,2f,d);


       /* diamond=new Gold(gl,0f,0f,-4f,3);
        diamond=new Gold(gl,4f,0f,-2f,1);
        diamond=new Gold(gl,0f,2f,4f,2);

        selected_vehicle = (selected_vehicle + 1) % 3;
        setUpVehicleBuffers();
        vehicles[selected_vehicle].Render(0f, 4f, 4f, 0, 0, 0);
        selected_vehicle = (selected_vehicle + 1) % 3;
        setUpVehicleBuffers();
        vehicles[selected_vehicle].Render(0f, 4f, -4f, 0, 0, 0);
        selected_vehicle = (selected_vehicle + 1) % 3;
        setUpVehicleBuffers();
        vehicles[selected_vehicle].Render(0f, -4f, 4f, 0, 0, 0);




        rocket.Render(-4f,0f,-2f);*/
            //BOD[0].Render(4f,0,0);
            //w1.Render(1f, true);
            //w2.Render(1f, false);
            //c1.Render(-CV.HeightOfLevels / 2, 0);
            //vehicles[selected_vehicle].Render(2f,2f,0,0,0,0);
            //BOD[0].Render(-4f + increaser % 8f, 4f - (increaser / 2f) % 8f, 0);
//
//
            //menus.AboutUs();


            //vehicles[selected_vehicle]=new ElectricRing(gl,true,-2f, 0, 0, 0, 0, 0);

            //rC.drawWithBuffers(gl,true, mVertexBuffer,mTriangleColorBuffer,mTriangleBorderIndicesBuffer,9);


            //fjkf(R.drawable.thecubenametag);

            //rC.drawWithBuffers(gl,mVertexBuffer,mTriangleColorBuffer,mTriangleUVBuffer,mTriangleBorderIndicesBuffer,18,R.drawable.speedyface);


            option = nextoption;
            if (option == 0) {



                my = (int) (Screen_Height) - my;
                my = my + 37 +bannerHeight;

                if (menuoption == 99 && completedMission[0] == 99 && completedMission[1] == 99 && completedMission[2] == 99) {

                    menuoption = 9;

                }


                gl.glDisable(GLES10.GL_DEPTH_TEST);


                //glOrtho(0,(double)Display.getWidth(),0,(double)Display.getHeight(), -1d,10d);
                //gluOrtho2D(0,Display.getWidth(),0,Display.getHeight());
                if (!mouseDown) {
                    framesSinceMenuClickActivated = framesSinceMenuClickActivated + 1;
                    MENU_CLICK_ACTIVATED = true;
                }
                //cam.useView(0,0,0,0,0,0);
                gl.glLoadIdentity();

                gl.glMatrixMode(GLES10.GL_PROJECTION);
                gl.glEnable(GLES10.GL_TEXTURE);
                gl.glClearColor(0, 0, 0, 1f);
                ///////////////////
                ////////////////////
                //////////messed up here with translatef
                /////////////////////
                ////////////////////

           /* if (que) {
                gl.glTranslatef(0, 0, -0.8f);

                que = false;
            }*/
                gl.glMatrixMode(GL10.GL_PROJECTION);
                gl.glEnable(GL10.GL_TEXTURE_2D);
                //glMatrixMode (GL_MODELVIEW);

                //	glDisable(GL_DEPTH_TEST);

                gl.glEnable(GL10.GL_BLEND);

                gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

                //sparevar = sparevar + 0.1f;

                //menuoption=0;


                gl.glPushMatrix();
                {
                    gl.glTranslatef(0, 0, -1.000001f);
                    if (menuoption == 0) {
                        menus.MainMenu();
                        //menus.Custom();

                    } else if (menuoption == 1) {
                        menus.Custom();
                    } else if (menuoption == 11) {
                        menus.VEHICLE_OVERVIEW_MENU(shipsSection);


                    } else if(menuoption ==31){
                        menus.THEME_OVERVIEW_MENU(font, selected_theme);

                    }else if (menuoption == 111) {
                        menus.VEHICLE_MENU(vehicles[selected_vehicle], selected_vehicle);
                        //menus.TICK_ICON();
                    } else if (menuoption == 21) {
                        menus.POWERUPS_MENU();
                    } else if (menuoption == 2) {
                        menus.HighScores();
                    } else if (menuoption == 3) {
                        //myMain.domService();
                        //if(myMain.mService!=null){
                        //  myMain.buyItem("gold_50000");
                        //}
                        //menuoption=0;
                        //menus.AboutUs();

                        menus.StoreMenu(font,storeoption);
                    }

                }
                gl.glPopMatrix();

                gl.glDisable(GL10.GL_TEXTURE_2D);
                //  glEnable(GL_DEPTH_TEST);
                //	glDisable(GL_BLEND);

	    /*
	     * 	    glBegin(GL_QUADS);
	    		    {


	    		    	glTexCoord2f(0f,0f);
	    		    	glVertex2f(-xaxis,yaxis);
	    		    	glTexCoord2f(0f,0f);
	    		    	glVertex2f(-xaxis,-yaxis);
	    		    	glTexCoord2f(0f,0f);
	    		    	glVertex2f(xaxis,-yaxis);
	    		        glTexCoord2f(0f,0f);
	    		    	glVertex2f(xaxis,yaxis);


	    		    }
	    		    glEnd();
	    *
	    */
	    		  /*
	    		    glDisable(GL_TEXTURE);
					//  glTranslatef(0f,0f,-20f);
					  glEnable (GL_TEXTURE_2D);
					  glEnable(GL_BLEND);
					  glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
					  glMatrixMode (GL_MODELVIEW);
					  glShadeModel(GL_SMOOTH);
					  glDisable(GL_DEPTH_TEST);
				   font.drawString(-5, -5, "h", Color.blue);
					  glDisable( GL_TEXTURE_2D);
					  glEnable(GL_DEPTH_TEST);
					  glDisable(GL_BLEND);
				    glPopMatrix();

				    */


                //glEnable(GL_DEPTH_TEST);
                //Display.sync(40);

                //	glDisable(GL_TEXTURE_2D);

                String md;
                if(mouseDown){
                    md="T";
                }else{
                    md="F";
                }
                if(MENU_CLICK_ACTIVATED){

                    //message="1 "+framesSinceMenuClickActivated +" "+md;
                }else{
                    //message="0 "+framesSinceMenuClickActivated +" "+md;
                }
                if (MENU_CLICK_ACTIVATED && framesSinceMenuClickActivated > 2
                        ) {
                    //message=message+" GO";
                    if (mouseDown) {
                        if (menuoption == 1 || menuoption == 2 || menuoption == 3) {
                            if (((float) Screen_Width / 512f * 50f < mx && mx < (float) Screen_Width / 512f * 100f
                                &&(float) (Screen_Height) / 512f * 50f < my && my < (float) Screen_Height / 512f * 100f)||turnsSinceBackButton<2) {
                                menuoption = 0;
                                MENU_CLICK_ACTIVATED = false;
                                turnsSinceBackButton =turnsSinceBackButton + 100f;
                            }
                        }
                        if (menuoption == 21) {


                        }
                        if (menuoption == 11) {
                            if ((float) Screen_Width / 512f * 400f < mx && mx < (float) Screen_Width / 512f * (400f + Screen_Width * 0.125f)) {
                                if ((float) Screen_Height / 512f * (80f) < my && my < (float) Screen_Height / 512f * (80f + Screen_Height * 0.125f)) {
                                    if (shipsSection == 0) {
                                        shipsSection = 1;
                                    } else {
                                        shipsSection = 0;
                                    }
                                    MENU_CLICK_ACTIVATED = false;

                                }

                            }
                            if (shipsSection == 0) {

                                if ((float) Screen_Width / 512f * 70f < mx && mx < (float) Screen_Width / 512f * 230f) {
                                    int w = 0;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 0 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 0 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour())/2 + (int) (vehicles[selected_vehicle].getArmourPlus())/2;
                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 1 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 1 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;
                                        setUpVehicleBuffers();

                                        MENU_CLICK_ACTIVATED = false;

                                    }
                                    w = w + 1;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 2 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 2 * menus.getDistanceFromTopToTop())))) {

                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }


                                }
                                if ((float) Screen_Width / 512f * (512f - 230f) < mx && mx < (float) Screen_Width / 512f * (512f - 70f)) {

                                    int w = 3;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 0 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 0 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;
                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;

                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 1 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 1 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;

                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 2 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 2 * menus.getDistanceFromTopToTop())))) {

                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }

                                /*w = w + 1;
                                if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 2 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 2 * menus.getDistanceFromTopToTop())))) {

                                    selected_vehicle = w;
                                    lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus());

                                    menuoption = 111;
                                    MENU_CLICK_ACTIVATED = false;

                                }*/
                                }
                            } else {

                                if ((float) Screen_Width / 512f * 70f < mx && mx < (float) Screen_Width / 512f * 230f) {
                                    int w = 6;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 0 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 0 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;
                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 1 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 1 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;

                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 2 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 2 * menus.getDistanceFromTopToTop())))) {

                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }


                                }
                                if ((float) Screen_Width / 512f * (512f - 230f) < mx && mx < (float) Screen_Width / 512f * (512f - 70f)) {

                                    int w = 9;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 0 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 0 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;
                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;

                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 1 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 1 * menus.getDistanceFromTopToTop())))) {
                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;

                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }
                                    w = w + 1;
                                    if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 2 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 2 * menus.getDistanceFromTopToTop())))) {

                                        selected_vehicle = w;
                                        lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus())/2;

                                        menuoption = 111;
                                        MENU_CLICK_ACTIVATED = false;
                                        setUpVehicleBuffers();

                                    }

                                /*w = w + 1;
                                if ((float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + menus.getHeightOfTags() + (float) 2 * menus.getDistanceFromTopToTop()))) < my && my < (float) (Screen_Height) - (float) (Screen_Height) / 512f * (((80f + 0 + (float) 2 * menus.getDistanceFromTopToTop())))) {

                                    selected_vehicle = w;
                                    lives = resetLives + (int) (vehicles[selected_vehicle].getArmour() + vehicles[selected_vehicle].getArmourPlus());

                                    menuoption = 111;
                                    MENU_CLICK_ACTIVATED = false;

                                }*/
                                }

                            }
                        }
                        if (menuoption == 0) {

                            if ((float) Screen_Width / 512f * 160f < mx && mx < (float) Screen_Width / 512f * 350f) {

                                if (MENU_CLICK_ACTIVATED&&(float) (Screen_Height) / 512f * 352f < my && my < (float) Screen_Height / 512f * 412f) {


                                    //LayoutParams params = myMain.mView.getLayoutParams();
                                    //params.height = (int)Screen_Height;
                                    //params.width  = (int)Screen_Width;
                                    //myMain.mView.setLayoutParams(params);

                                    nextoption = 1;
                                    vehicles[0].setBought(1);
                                    if (vehicles[selected_vehicle].getBought() != 1) {
                                        selected_vehicle = 0;

                                    }
                                    MENU_CLICK_ACTIVATED = false;
                                    lives = resetLives + (int) (vehicles[selected_vehicle].getArmourPlus() + vehicles[selected_vehicle].getArmour())/2;

                                    if (mx > (float) Screen_Width * 0.5f) {
                                        simple = true;
                                    } else {
                                        simple = false;
                                    }
                                    Checkpoint1=Checkpoint1base-Checkpoint1mod*((vehicles[selected_vehicle].getLuck()+vehicles[selected_vehicle].getLuckPlus()));
                                    Checkpoint2=Checkpoint2base-Checkpoint2mod*((vehicles[selected_vehicle].getLuck()+vehicles[selected_vehicle].getLuckPlus()));

                                    setUpBuffers();
                                }

                                if (MENU_CLICK_ACTIVATED&&(float) (Screen_Height) / 512f * 262f < my && my < (float) Screen_Height / 512f * 322f) {
                                    menuoption = 1;
                                    MENU_CLICK_ACTIVATED = false;

                                }

                                if (MENU_CLICK_ACTIVATED&&(float) (Screen_Height) / 512f * 172f < my && my < (float) Screen_Height / 512f * 232f) {
                                    menuoption = 2;
                                    MENU_CLICK_ACTIVATED = false;

                                }

                                if (MENU_CLICK_ACTIVATED&&(float) (Screen_Height) / 512f * 82f < my && my < (float) Screen_Height / 512f * 142f) {
                                    menuoption = 3;
                                    storeoption=0;
                                    MENU_CLICK_ACTIVATED = false;

                                }

                            }


                        }
                    }
                    if (MENU_CLICK_ACTIVATED) {
                        if (mouseDown) {
                            if (menuoption == 21) {
                                if ((float) Screen_Width / 512f * 120f < mx && mx < (float) Screen_Width / 512f * 170f) {
                                    if ((float) (Screen_Height) / 512f * 377f < my && my < (float) Screen_Height / 512f * 427f) {
                                        if (frequencyUpgradeNumber < 5 && gold > 200 * (int) Math.pow(2, frequencyUpgradeNumber)) {
                                            //gold = gold - 400 * (int) Math.pow(2, frequencyUpgradeNumber);
                                            gold = gold - goldFor(2,0,frequencyUpgradeNumber);
                                            frequencyUpgradeNumber = frequencyUpgradeNumber + 1;

                                        }
                                        MENU_CLICK_ACTIVATED = false;

                                    }
                                    if ((float) (Screen_Height) / 512f * 307f < my && my < (float) Screen_Height / 512f * 357f) {
                                        if (SpeedyUpgradeNumber < 5 && gold > 100 * (int) Math.pow(2, SpeedyUpgradeNumber)) {
                                            //gold = gold - 200 * (int) Math.pow(2, SpeedyUpgradeNumber);
                                            gold = gold - goldFor(2,1,SpeedyUpgradeNumber);

                                            SpeedyUpgradeNumber++;

                                        }
                                        MENU_CLICK_ACTIVATED = false;
                                    }
                                    if ((float) (Screen_Height) / 512f * 237f < my && my < (float) Screen_Height / 512f * 287f) {
                                        if (InvincibilityUpgradeNumber < 5 && gold > 100 * (int) Math.pow(2, InvincibilityUpgradeNumber)) {
                                            gold = gold - goldFor(2,1,InvincibilityUpgradeNumber);
                                            InvincibilityUpgradeNumber++;
                                        }
                                        MENU_CLICK_ACTIVATED = false;
                                    }
                                    if ((float) (Screen_Height) / 512f * 167f < my && my < (float) Screen_Height / 512f * 217f) {
                                        if (MagnetUpgradeNumber < 5 && gold > 100 * (int) Math.pow(2, MagnetUpgradeNumber)) {
                                            gold = gold - goldFor(2,1,MagnetUpgradeNumber);
                                            MagnetUpgradeNumber++;
                                        }
                                        MENU_CLICK_ACTIVATED = false;
                                    }
                                    if ((float) (Screen_Height) / 512f * 97f < my && my < (float) Screen_Height / 512f * 147f) {
                                        if (ChestUpgradeNumber < 5 && gold > 100 * (int) Math.pow(2, ChestUpgradeNumber)) {
                                            gold = gold - goldFor(2,1,ChestUpgradeNumber);
                                            ChestUpgradeNumber++;
                                        }
                                        MENU_CLICK_ACTIVATED = false;
                                    }


                                }


                            }


                            if (menuoption == 31) {
                                if ((float) Screen_Width / 512f * 60f < mx && mx < (float) Screen_Width / 512f * 122f) {
                                    if ((float) (Screen_Height) / 512f * 362f < my && my < (float) Screen_Height / 512f * 427f) {
                                        selected_theme=0;

                                        MENU_CLICK_ACTIVATED = false;

                                    }
                                    if ((float) (Screen_Height) / 512f * 272f < my && my < (float) Screen_Height / 512f * 337f) {
                                        if(theme.getPPbought()){
                                            selected_theme=1;

                                        }else{
                                            menuoption = 3;
                                            storeoption = 1;
                                        }

                                        MENU_CLICK_ACTIVATED = false;
                                    }
                                }
                            }

                            if (menuoption == 3&& MyRenderer.MENU_CLICK_ACTIVATED==true) {
                                if(storeoption==0) {
                                    if ((float) Screen_Width / 512f * 60f < mx && mx < (float) Screen_Width / 512f * 122f) {
                                        if ((float) (Screen_Height) / 512f * 352f < my && my < (float) Screen_Height / 512f * 422f) {
                                            myMain.domService();
                                            //if(myMain.mService!=null){
                                                myMain.buyItem("gold_10000");
                                            //}
                                            MENU_CLICK_ACTIVATED = false;

                                        }
                                        if ((float) (Screen_Height) / 512f * 272f < my && my < (float) Screen_Height / 512f * 342f) {

                                            myMain.domService();
                                            //if(myMain.mService!=null){
                                                myMain.buyItem("gold_50000");
                                            //}
                                            MENU_CLICK_ACTIVATED = false;
                                        }

                                        if ((float) (Screen_Height) / 512f * 192f < my && my < (float) Screen_Height / 512f * 262f) {
                                            myMain.domService();
                                            //if(myMain.mService!=null){
                                                myMain.buyItem("gold_150000");
                                            //}
                                            MENU_CLICK_ACTIVATED = false;

                                        }
                                        if ((float) (Screen_Height) / 512f * 112f < my && my < (float) Screen_Height / 512f * 182f) {

                                            myMain.domService();
                                            //if(myMain.mService!=null){
                                                myMain.buyItem("gold_500000");
                                            //}
                                            MENU_CLICK_ACTIVATED = false;
                                        }

                                    }
                                    if ((float) Screen_Width / 512f * 400f < mx && mx < (float) Screen_Width / 512f * (400f + Screen_Width * 0.125f)) {
                                        if ((float) Screen_Height / 512f * (40f) < my && my < (float) Screen_Height / 512f * (40f + Screen_Height * 0.125f)) {
                                            storeoption = 1;

                                            MENU_CLICK_ACTIVATED = false;
                                        }
                                    }



                                }
                                else if(storeoption==1){

                                    if ((float) Screen_Width / 512f * 60f < mx && mx < (float) Screen_Width / 512f * 122f) {
                                        if ((float) (Screen_Height) / 512f * 352f < my && my < (float) Screen_Height / 512f * 422f) {
                                            myMain.domService();
                                            //if(myMain.mService!=null){
                                                myMain.buyItem("gem_100");
                                            //}

                                            MENU_CLICK_ACTIVATED = false;

                                        }
                                        if ((float) (Screen_Height) / 512f * 272f < my && my < (float) Screen_Height / 512f * 342f) {

                                            myMain.domService();
                                            if(!flying_saucer){
                                                myMain.buyItem("flying_saucer");
                                            }
                                            MENU_CLICK_ACTIVATED = false;
                                        }

                                        if ((float) (Screen_Height) / 512f * 192f < my && my < (float) Screen_Height / 512f * 262f) {
                                            myMain.domService();
                                            if(!pptheme){
                                                myMain.buyItem("theme_paperplane");
                                            }
                                            MENU_CLICK_ACTIVATED = false;

                                        }
                                        if ((float) (Screen_Height) / 512f * 112f < my && my < (float) Screen_Height / 512f * 182f) {
                                            myMain.domService();
                                            if(!noads){
                                                myMain.buyItem("no_ads");
                                            }

                                            MENU_CLICK_ACTIVATED = false;
                                        }


                                    }
                                    if ((float) Screen_Width / 512f * 400f < mx && mx < (float) Screen_Width / 512f * (400f + Screen_Width * 0.125f)) {
                                        if ((float) Screen_Height / 512f * (40f) < my && my < (float) Screen_Height / 512f * (40f + Screen_Height * 0.125f)) {
                                            storeoption = 0;

                                            MENU_CLICK_ACTIVATED = false;
                                        }
                                    }

                                }
                            }

                            if (menuoption == 111) {

                                if ((float) Screen_Width / 512f * 512f * 0.86f < mx && mx < (float) Screen_Width / 512f * 512f * 0.985f) {
                                    if ((float) Screen_Height / 512f * 512f * 0.81f < my && my < (float) Screen_Height / 512f * 512f * 0.935f) {
                                        if (selected_vehicle!=10&&vehicles[selected_vehicle].getBought() == 0 && gold > goldFor(0, selected_vehicle, 0)) {

                                            gold = gold - goldFor(0, selected_vehicle, 0);
                                            vehicles[selected_vehicle].setBought(1);


                                        }else{
                                            if(vehicles[selected_vehicle].getBought() == 0) {
                                                menuoption = 3;
                                                storeoption = 1;

                                            }
                                    }

                                        MENU_CLICK_ACTIVATED = false;
                                    }
                                }


                                if ((float) Screen_Width / 512f * 205f < mx && mx < (float) Screen_Width / 512f * 240f && vehicles[selected_vehicle].getBought() == 1) {
                                    if ((float) (Screen_Height) / 512f * 40f < my && my < (float) Screen_Height / 512f * 75f) {
                                        float cost=goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getArmourPlus()+1);
                                        if (vehicles[selected_vehicle].getArmourPlus() < maxUpgrade && gold > cost) {
                                            gold = gold - cost;
                                            vehicles[selected_vehicle].setArmourPlus(vehicles[selected_vehicle].getArmourPlus() + 2f);

                                        }

                                        MENU_CLICK_ACTIVATED = false;
                                        vehicles[selected_vehicle].setNotInitialized(true);

                                    }
                                /*
                                if ((float) (Screen_Height) / 512f * 130f < my && my < (float) Screen_Height / 512f * 165f) {
                                    if ((double) vehicles[selected_vehicle].getSizePlus() < 6 && gold > 100f * (float) Math.pow(2d, (double) vehicles[selected_vehicle].getSizePlus())) {
                                        gold = gold - 100f * (float) Math.pow(2d, (double) (vehicles[selected_vehicle].getSizePlus()));
                                        vehicles[selected_vehicle].setSizePlus(vehicles[selected_vehicle].getSizePlus() + 1f);
                                        vehicles[selected_vehicle].redoInitialisation();
                                    }


                                    MENU_CLICK_ACTIVATED = false;
                                    vehicles[selected_vehicle].setNotInitialized(true);
                                }*/
                                    if ((float) (Screen_Height) / 512f * 130f < my && my < (float) Screen_Height / 512f * 165f) {
                                        float cost=goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getSizePlus());
                                        if (vehicles[selected_vehicle].getSizePlus() < maxUpgrade && gold > cost) {
                                            gold = gold - cost;
                                            vehicles[selected_vehicle].setSizePlus(vehicles[selected_vehicle].getSizePlus() + 1f);
                                            vehicles[selected_vehicle].redoInitialisation();
                                            setUpVehicleBuffers();

                                        }

                                        MENU_CLICK_ACTIVATED = false;
                                        vehicles[selected_vehicle].setNotInitialized(true);


                                    }
                                    if ((float) (Screen_Height) / 512f * 214f < my && my < (float) Screen_Height / 512f * 250f) {
                                        float cost=goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getLuckPlus());
                                        if (vehicles[selected_vehicle].getLuckPlus() < maxUpgrade && gold > cost) {
                                            gold = gold - cost;
                                            vehicles[selected_vehicle].setLuckPlus(vehicles[selected_vehicle].getLuckPlus() + 1f);
                                            vehicles[selected_vehicle].setNotInitialized(true);
                                        }


                                        MENU_CLICK_ACTIVATED = false;
                                        vehicles[selected_vehicle].setNotInitialized(true);
                                    }
                                    if ((float) (Screen_Height) / 512f * 300f < my && my < (float) Screen_Height / 512f * 340f) {
                                        float cost=goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getHandlingPlus());
                                        if (vehicles[selected_vehicle].getHandlingPlus() < maxUpgrade && gold > cost) {
                                            gold = gold - cost;
                                            vehicles[selected_vehicle].setHandlingPlus(vehicles[selected_vehicle].getHandlingPlus() + 1f);
                                        }
                                        MENU_CLICK_ACTIVATED = false;
                                        vehicles[selected_vehicle].setNotInitialized(true);
                                    }


                                }
                            }

                            if (MENU_CLICK_ACTIVATED&&(menuoption == 11||menuoption==31)) {
                                if ((float) Screen_Width / 512f * 50f < mx && mx < (float) Screen_Width / 512f * 100f) {
                                    if ((float) (Screen_Height) / 512f * 50f < my && my < (float) Screen_Height / 512f * 100f) {
                                        menuoption = 1;
                                        MENU_CLICK_ACTIVATED = false;
                                    }

                                }else if(turnsSinceBackButton<2){
                                    menuoption=1;
                                    turnsSinceBackButton =turnsSinceBackButton + 100f;
                                    MENU_CLICK_ACTIVATED = false;
                                }

                            }
                            if (MENU_CLICK_ACTIVATED&&menuoption == 111 || menuoption == 211) {
                                if ((float) Screen_Width / 512f * 50f < mx && mx < (float) Screen_Width / 512f * 100f) {
                                    if ((float) (Screen_Height) / 512f * 50f < my && my < (float) Screen_Height / 512f * 100f) {
                                        menuoption = 11;
                                        MENU_CLICK_ACTIVATED = false;
                                    }

                                }else if(turnsSinceBackButton<2){
                                    menuoption=11;
                                    turnsSinceBackButton =turnsSinceBackButton + 100f;
                                    MENU_CLICK_ACTIVATED = false;
                                }
                                //if ((float)Display.getWidth()/512f*50f<mx&&mx<(float)Display.getWidth()/512f*100f){
                                //	if ((float)(Display.getHeight())/512f*50f<my&&my<(float)Display.getHeight()/512f*100f){
                                //		menuoption=11;
                                //		MENU_CLICK_ACTIVATED=false;
                                //	}

                                //}

                            }
                            if (MENU_CLICK_ACTIVATED&&menuoption == 21) {
                                if ((float) Screen_Width / 512f * 50f < mx && mx < (float) Screen_Width / 512f * 100f) {
                                    if ((float) (Screen_Height) / 512f * 50f < my && my < (float) Screen_Height / 512f * 100f) {
                                        menuoption = 1;
                                        MENU_CLICK_ACTIVATED = false;
                                    }

                                }else if(turnsSinceBackButton<2){
                                    menuoption=1;
                                    turnsSinceBackButton =turnsSinceBackButton + 100f;
                                    MENU_CLICK_ACTIVATED = false;
                                }
                            }
                            if (menuoption == 1) {


                                if ((float) Screen_Width / 512f * 80f < mx && mx < (float) Screen_Width / 512f * 428f) {
                                    if ((float) (Screen_Height) / 512f * 332f < my && my < (float) Screen_Height / 512f * 432f) {
                                        menuoption = 11;
                                        MENU_CLICK_ACTIVATED = false;


                                    }
                                    if ((float) (Screen_Height) / 512f * 222f < my && my < (float) Screen_Height / 512f * 322f) {
                                        menuoption = 21;
                                        MENU_CLICK_ACTIVATED = false;

                                    }
                                    if ((float) (Screen_Height) / 512f * 112f < my && my < (float) Screen_Height / 512f * 212f) {
                                        menuoption = 31;
                                        MENU_CLICK_ACTIVATED = false;

                                    }
                                }

                            }
                            if (menuoption == 9 && waitFrames<=0&& !waitLater) {

                                menuoption = 0;
                                MENU_CLICK_ACTIVATED = false;

                            }
                            if (menuoption == 99 && waitFrames<=0) {

                                for (int c4 = 0; c4 < completedMission.length; c4++) {
                                    completedMission[c4] = 99;
                                }
                                resetMissions();
                                save();
                                menuoption = 9;
                                MENU_CLICK_ACTIVATED = false;
                                waitFrames=3;



                            }

                        }

                    }
                    if (!MENU_CLICK_ACTIVATED) {
                        framesSinceMenuClickActivated = 0;
                    }
                    save();


                }

                allowListeners = true;


                //Display.update();
                //glClear(GL_DEPTH_BUFFER_BIT);
                //Display.update();


                //glOrtho(1,-1,1,-1,-1500,1500);
                gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
                gl.glEnable(GL10.GL_TEXTURE_2D);

                gl.glPushMatrix();
                {

                    //gl.glRotatef(180f, 0, 0, 1);//Rotate text so that it is not upside down and the wrong way around.
                    gl.glRotatef(180, 0, 1, 0);
                    gl.glTranslatef(aspect * 0.9f, 0.85f, 1.00001f);

                    //reverse x-axis
		    			/*
		    			 *
		    			 * By the way:
		    			 * 1. y-axis inverted
		    			 * 2. x-axis point
		    			 *
		    			 */
                    //font2.drawString(-750f, -568, "GOLD - $"+(int)gold, Color.cyan);
                    //mainString="GOLD  "+Integer.toString((int)gold);
                    gl.glColor4f(1, 1, 1, 0.6f);
                    mainString = "GOLD";
                    font.drawFont(0* xaxis, 0 * yaxis, 0, 0.07f * (float) mainString.length()* xaxis, 0.1f*yaxis, mainString);
                    mainString = Integer.toString((int) gold);

                    //gl.glPushMatrix();
                    //{
                    //    //gl.glTranslatef(((float) mainString.length()*-0.035f+2*0.035f)*aspect,-0.1f,0);
                    //    gl.glTranslatef(((float) 0.08f) * aspect, -0.1f, 0);

                        font.drawFont(0* xaxis, -0.1f * yaxis, 0, 0.07f * (float) mainString.length()* xaxis, 0.1f*yaxis, mainString);
                    //}
                    //gl.glPopMatrix();

                    gl.glColor4f(1, 1, 1, 0.6f);
                    mainString = "GEMS";
                    font.drawFont(1.45f * xaxis, 0 * yaxis, 0, 0.07f * (float) mainString.length()* xaxis, 0.1f, mainString);
                    mainString = message;
                    font.drawFont(0 * xaxis, 0 * yaxis, 1.0001f, 0.07f * (float) mainString.length()* xaxis, 0.1f, mainString);

                    mainString = Integer.toString((int) gems);
                    font.drawFont((1.45f+0.07f*2f - 0.07f/2f * mainString.length()) * xaxis, -0.1f, 0, 0.07f * (float) mainString.length()* xaxis, 0.1f, mainString);
                    /*
                    mainString = "fps " + Integer.toString((int) fps);

                    gl.glPushMatrix();
                    {
                        //gl.glTranslatef(((float) mainString.length()*-0.035f+2*0.035f)*aspect,-0.1f,0);
                        gl.glTranslatef(-((float) 1.4f) * xaxis + mx / Screen_Width * 2f, -0.1f, 0);

                        font.drawFont(0, 0, 0, 0.07f * (float) mainString.length(), 0.1f, mainString);
                    }
                    gl.glPopMatrix();
                    */
                /*
                mainString=Integer.toString((int)(mx//*Screen_Width
                ));
                gl.glPushMatrix();
                {
                    gl.glTranslatef(((float) mainString.length()*-0.035f+2*0.035f)*aspect,-0.2f,0);

                    font.drawFont(0, 0, 0, 0.07f * (float) mainString.length(), 0.1f, mainString);
                }
                gl.glPopMatrix();

                mainString=Integer.toString((int)(my//*Screen_Height
                 ));

                gl.glPushMatrix();
                {
                    gl.glTranslatef(((float) mainString.length()*-0.035f+2*0.035f)*aspect,-0.3f,0);

                    font.drawFont(0, 0, 0, 0.07f * (float) mainString.length(), 0.1f, mainString);
                }
                gl.glPopMatrix();

                if (mouseDown) {
                    mainString = "TRUE";
                }else{
                    mainString = "FALSE";

                }

                gl.glPushMatrix();
                {
                    gl.glTranslatef(((float) mainString.length()*-0.035f+2*0.035f)*aspect,-0.4f,0);

                    font.drawFont(0, 0, 0, 0.07f * (float) mainString.length(), 0.1f, mainString);
                }
                gl.glPopMatrix();
*/

                    if (menuoption == 111) {//vehicle buy menu


                        float var1 = 0.14f;//- left + right
                        if(selected_vehicle!=10){
                            mainString = "G" + (int) goldFor(0,selected_vehicle,0);}else{
                            mainString = "STORE";
                        }
                        if (vehicles[selected_vehicle].getBought() == 1) {


                            gl.glPushMatrix();
                            {
                                gl.glTranslatef(((float) mainString.length() * 0.035f/2f - 2f * (0.73f + var1)) * aspect, -0.325f, 0);
                                gl.glColor4f(0, 1f, 0, 1f);
                                font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length()* aspect, 0.08f, mainString);//green
                            }
                            gl.glPopMatrix();
                        } else {
                            gl.glPushMatrix();
                            {
                                gl.glTranslatef(((float) mainString.length() * 0.035f/2f - 2f * (0.73f + var1)) * aspect, -0.325f, 0);
                                gl.glColor4f(0, 1f, 0, 1f);
                                font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length()* aspect, 0.08f, mainString);//green
                            }
                            gl.glPopMatrix();
                        }

                        float var2 = -0.45f;//+ to move left  - to move right
                        float var3 = -0.32f;//+to move up     - to move down
                        float y_interval = -0.34f;


                        gl.glPushMatrix();
                        {
                            if(vehicles[selected_vehicle].getHandlingPlus()<maxUpgrade) {
                                mainString = "G" + Integer.toString((int)goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getHandlingPlus()));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef((0.015f + var2) * aspect, -0.325f + 0 * y_interval + var3, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length()* aspect, 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {
                            if(vehicles[selected_vehicle].getLuckPlus()<maxUpgrade) {
                                mainString = "G" + Integer.toString((int) goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getLuckPlus()));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef((0.015f + var2) * aspect, -0.325f + 1f * y_interval + var3, 0);
                            font.drawFont(00f, 0, 0, 0.0325f * (float) mainString.length()* aspect, 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {
                            if(vehicles[selected_vehicle].getSizePlus()<maxUpgrade) {
                                mainString = "G" + Integer.toString((int) goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getSizePlus()));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef(( + 0.015f + var2) * aspect, -0.325f + 2f * y_interval + var3, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length()* aspect, 0.08f, mainString);//red
                            // mainString="G"+Integer.toString((int) 100 * (int) Math.pow(2, vehicles[selected_vehicle].getSizePlus()));
                            // mainString=Float.toString(vehicles[selected_vehicle].getLuckPlus());
                            // gl.glTranslatef(((float) mainString.length() * -0.035f + 0.015f+var2) * aspect, -0.325f + 2f * y_interval+var3, 0);
                            // gl.glColor4f(1f, 1f, 1f, 1f);
                            // font.drawFont(0,0,0,0.0325f*(float)mainString.length(),0.08f,mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {

                            if(vehicles[selected_vehicle].getArmourPlus()<maxUpgrade) {
                                mainString = "G" + Integer.toString((int) goldFor(1,selected_vehicle,(int)vehicles[selected_vehicle].getArmourPlus()/2+1));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef(( + 0.015f + var2) * aspect, -0.325f + 3f * y_interval + var3, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length()* aspect, 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();

                        gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);

                        gl.glEnable(GL10.GL_DEPTH_TEST);
                        gl.glPushMatrix();

                        changer=changer + 10f;
                        gl.glTranslatef(18f*aspect,1.5f,30f);
                        vehicles[0].Render(0, 0, 0, changer, 0, 0);
                        gl.glPopMatrix();
                        gl.glDisable(GL10.GL_DEPTH_TEST);

                        //font2.drawString(-335f, -168, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getHandlingPlus()))*100, Color.black);
                        //font2.drawString(-335f, 25, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getLuckPlus()))*100, Color.black);
                        //font2.drawString(-335f, 215, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getSizePlus()))*100, Color.black);
                        //font2.drawString(-335f, 410, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getArmourPlus()))*100, Color.black);
                    }
                    if (menuoption == 21) {//UPGRADES MENU

                    /*
                    CHANGES:
                    1. The text blocks used to go right by 0.035f for each  character in the cost String however
                    this resulted in the String appearing outside the menu so the mainString.length was replaced
                     in all cases by 5f.

                     */

                        float var1 = 0.12f;//+ to move left - to move right

                        gl.glPushMatrix();
                        {
                            if(frequencyUpgradeNumber<maxPowUpgradeNumber) {
                                mainString = "G" + Integer.toString((int) goldFor(2,0,frequencyUpgradeNumber));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef(((float) 5f * -0.035f + 0.015f + var1) * aspect, -0.325f + 0 * -0.27f, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) (mainString.length()), 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {
                            if(SpeedyUpgradeNumber<maxPowUpgradeNumber) {
                                mainString = "G" + Integer.toString((int) goldFor(2,1,SpeedyUpgradeNumber));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }

                            gl.glTranslatef(((float) 5f * -0.035f + 0.015f + var1) * aspect, -0.325f + 1f * -0.27f, 0);
                            font.drawFont(00f, 0, 0, 0.0325f * (float) mainString.length(), 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {
                            if(InvincibilityUpgradeNumber<maxPowUpgradeNumber) {
                                mainString = "G" + Integer.toString((int) goldFor(2,1,InvincibilityUpgradeNumber));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef(((float) 5f * -0.035f + 0.015f + var1) * aspect, -0.325f + 2f * -0.27f, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length(), 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {
                            if(MagnetUpgradeNumber<maxPowUpgradeNumber) {
                                mainString = "G" + Integer.toString((int) goldFor(2,1,MagnetUpgradeNumber));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef(((float) 5f * -0.035f + 0.015f + var1) * aspect, -0.325f + 3f * -0.27f, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length(), 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();
                        {

                            if(ChestUpgradeNumber<maxPowUpgradeNumber) {
                                mainString = "G" + Integer.toString((int) goldFor(2,1,ChestUpgradeNumber));
                                gl.glColor4f(1f, 1f, 1f, 1f);

                            }else{
                                mainString ="MAX";
                                gl.glColor4f(1f, 0f, 0f, 1f);

                            }
                            gl.glTranslatef(((float) 5f * -0.035f + 0.015f + var1) * aspect, -0.325f + 4f * -0.27f, 0);
                            font.drawFont(0, 0, 0, 0.0325f * (float) mainString.length(), 0.08f, mainString);//red


                        }
                        gl.glPopMatrix();
                    }

                    if (menuoption == 2) {
                        for (c = 0; c < highScores.length; c++) {
                        /*if (c < (9)) {
                            //font2.drawString(-570f, -360+(float)c*70f, (c+1)+".  "+"  "+Integer.toString((int)highScores[highScores.length-1-c]), Color.red);
                        } else {
                            //font2.drawString(-570f, -360+(float)c*70f, (c+1)+".  "+""+Integer.toString((int)highScores[highScores.length-1-c]), Color.red);


                        }*/
                            if ((c + 1) < 10) {
                                mainString = (c + 1) + "  " + Integer.toString((int) highScores[highScores.length - 1 - c]);

                            } else {
                                mainString = (c + 1) + " " + Integer.toString((int) highScores[highScores.length - 1 - c]);

                            }
                            gl.glPushMatrix();
                            {
                                gl.glTranslatef((-0.35f + 0.015f) * aspect, -0.325f + (float) c * -0.12f, 0);
                                gl.glColor4f(1f, 1f, 1f, 1f);

                                font.drawFont(0, 0, 0, 0.06f * (float) mainString.length(), 0.07f, mainString);//red


                            }
                            gl.glPopMatrix();
                        }
                    }

                    if (menuoption == 9) {


                        gl.glClearColor(1f, 1f, 1f, 1f);
                        float fontHeights = 0.087f;
                        float fontWidths = 0.045f;

                        try {
                            lastRunFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir() + "/lastRun.txt")));

                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        String[] hold = new String[9];
                        for (int c = 0; c < hold.length; c++) {
                            hold[c] = "";
                        }
                        //String[] holder = {"DISTANCE          : ", "GOLD COINS        : ", "SCORE             : ", "Power Ups               : "};
                        String[] holder = {"SCORE             : ", "DISTANCE          : ", "GOLD COINS        : ", "Power Ups               : "};

                        int p = 0;
                        try {
                            while ((hold[p] = lastRunFileReader.readLine()) != null) {
                                    if (p == 3 ) {//THIS IS ONLY CALLED AT SECOND HALF OF FILE READING
                                        //font2.drawString(-570f, -360+(float)p*100f,    ("EXTRA GOLD                    : "+(int)(Float.parseFloat(hold[0])*0.01f)), Color.red);
                                    /*gl.glPushMatrix();
                                    {
                                        gl.glTranslatef((-0.02f) * aspect, -0.4f - (float) (p+1) * fontHeights, 0);
                                        gl.glColor4f(0f, 1f, 0f, 1f);

                                        mainString = ("EXTRA GOLD        : " + Integer.toString((int) (Float.parseFloat(hold[0]) * 0.01f)));
                                        font.drawFont(0, 0, 0, aspect*fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                    }
                                    gl.glPopMatrix();*/
                                        //font2.drawString(-570f, -360+(float)(p+1)*100f, "TOTAL GOLD EARNED   : "+(int)(Float.parseFloat(hold[1])+Float.parseFloat(hold[0])*0.01f), Color.red);
                                        gl.glPushMatrix();
                                        {
                                            gl.glTranslatef((-0.02f) * aspect, -0.25f - (float) (p + 1) * fontHeights, 0);
                                            gl.glColor4f(1f, 1f, 1f, 1f);

                                            mainString = "MULTIPLIER        : " + Float.toString((multipler+0.03f - (multipler+0.03f) % 0.1f
                                            ));
                                            font.drawFont(0, 0, 0, aspect * fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                        }
                                        gl.glPopMatrix();

                                        gl.glPushMatrix();
                                        {
                                            gl.glTranslatef((-0.02f) * aspect, -0.25f - (float) (p + 2) * fontHeights, 0);
                                            gl.glColor4f(1f, 1f, 1f, 1f);

                                            mainString = "TOTAL GOLD EARNED : " + Integer.toString((int) (multipler * (Float.parseFloat(hold[2]) + (Float.parseFloat(hold[1])*10f / 200f))));
                                            font.drawFont(0, 0, 0, aspect * fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                        }
                                        gl.glPopMatrix();

                                    } else if (p == 2) {
                                        // font2.drawString(-570f, -360+(float)p*100f, (holder[p]+hold[p]), Color.red);

                                        gl.glPushMatrix();
                                        {//this will be for the extra gold from distance
                                            gl.glTranslatef((-0.02f) * aspect, -0.25f - (float) p * fontHeights, 0);
                                            gl.glColor4f(1f, 1f, 1f, 1f);

                                            //mainString = "EXTRA GOLD        : " + Integer.toString(Integer.parseInt(hold[1]) / 100);
                                            mainString = "EXTRA GOLD        : " + Integer.toString((int)(Float.parseFloat(hold[1])*10f / 200f));

                                            font.drawFont(0, 0, 0, aspect * fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                        }
                                        gl.glPopMatrix();

                                        gl.glPushMatrix();
                                        {//this is GOLD COINS
                                            gl.glTranslatef((-0.02f) * aspect, -0.25f - (float) (p + 1) * fontHeights, 0);
                                            gl.glColor4f(1f, 1f, 1f, 1f);

                                            mainString = (holder[p] + hold[p]);
                                            font.drawFont(0, 0, 0, aspect * fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                        }
                                        gl.glPopMatrix();
                                    } else {
                                        // font2.drawString(-570f, -360+(float)p*100f, (holder[p]+hold[p]), Color.red);

                                        gl.glPushMatrix();
                                        {
                                            gl.glTranslatef((-0.02f) * aspect, -0.25f - (float) p * fontHeights, 0);
                                            gl.glColor4f(1f, 1f, 1f, 1f);

                                            mainString = (holder[p] + hold[p]);
                                            font.drawFont(0, 0, 0, aspect * fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                        }
                                        gl.glPopMatrix();
                                    }
                                    p++;

                            }
                            //font2.drawString(-570,460,"",Color.orange);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                        for (c = 0; c < selectedMission.length; c++) {

                            int mission = selectedMission[c];
                            if (mission != 99) {
                                //font2.drawString(-570f, 180+(c)*100, missionTitles[mission]+"  "+missionUpgradeTitles[missionProgress[mission]], Color.orange);
                                String description = "";
                                String rewarddescription = "";
                                int level=missionProgress[selectedMission[c]];
                                switch (selectedMission[c]) {
                                    case 0:
                                        description = Integer.toString(calculateMissionObjective(selectedMission[c], level) / 10) + " METRES";
                                        //description = (goldFor(3,selectedMission[c],missionProgress[selectedMission[c]]+1d)) + " METRES";

                                        //rewarddescription = "REWARD : " + Integer.toString(250 * (int) Math.pow(2d, (double) missionProgress[mission] + 1d));
                                        rewarddescription = "REWARD : " + Integer.toString((int)goldFor(3,selectedMission[c],(int)missionProgress[selectedMission[c]]+1));

                                        break;
                                    case 1:
                                        description = Integer.toString(calculateMissionObjective(selectedMission[c],level)) + " POINTS";

                                        //rewarddescription = "REWARD : " + Integer.toString(250 * (int) Math.pow(2d, (double) missionProgress[mission] + 1d));
                                        rewarddescription = "REWARD : " + Integer.toString((int)goldFor(3,selectedMission[c],(int)missionProgress[selectedMission[c]]+1));

                                        break;
                                    case 2:
                                        description = Integer.toString(calculateMissionObjective(selectedMission[c],level)) + " GOLD";

                                        //rewarddescription = "REWARD : " + Integer.toString(250 * (int) Math.pow(2d, (double) missionProgress[mission] + 1d));
                                        rewarddescription = "REWARD : " + Integer.toString((int)goldFor(3,selectedMission[c],(int)missionProgress[selectedMission[c]]+1));

                                        break;
                                    case 3:
                                        description = Integer.toString(calculateMissionObjective(selectedMission[c],level)) + " POWER-UPS";

                                        //rewarddescription = "REWARD : " + Integer.toString(250 * (int) Math.pow(2d, (double) missionProgress[mission] + 1d));
                                        rewarddescription = "REWARD : " + Integer.toString((int)goldFor(3,selectedMission[c],(int)missionProgress[selectedMission[c]]+1));

                                        break;
                                    case 4:
                                        description = Integer.toString(calculateMissionObjective(selectedMission[c],level)/10) + " METRES";

                                        //rewarddescription = "REWARD : " + Integer.toString(250 * (int) Math.pow(2d, (double) missionProgress[mission] + 1d));
                                        rewarddescription = "REWARD : " + Integer.toString((int)goldFor(3,selectedMission[c],(int)missionProgress[selectedMission[c]]+1));

                                        break;
                                    default:

                                        break;

                                }
                                // font.drawString(-570f, 180+c*100+60, missionDescriptions[mission]+description , Color.orange);


                                gl.glPushMatrix();
                                {
                                    gl.glTranslatef((-0.02f) * aspect, -0.4f - (float) (6 + c * 4) * fontHeights, 0);
                                    gl.glColor4f(1f, 1f, 1f, 1f);

                                    mainString = missionDescriptions[mission] + description;
                                    font.drawFont(0, 0, 0, aspect*fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                }
                                gl.glPopMatrix();
                                gl.glPushMatrix();
                                {
                                    gl.glTranslatef((-0.02f) * aspect, -0.4f - (float) (7 + c * 4) * fontHeights, 0);
                                    gl.glColor4f(1f, 1f, 1f, 1f);

                                    mainString = rewarddescription;
                                    font.drawFont(0, 0, 0, aspect*fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                }
                                gl.glPopMatrix();
                                gl.glPushMatrix();
                                {
                                    gl.glTranslatef((-0.02f) * aspect, -0.4f - (float) (8 + c * 4) * fontHeights, 0);
                                    gl.glColor4f(1f, 1f, 1f, 1f);

                                    mainString = missionTitles[mission] + "  " + missionUpgradeTitles[missionProgress[mission]];
                                    font.drawFont(0, 0, 0, aspect*fontWidths * (float) mainString.length(), fontHeights, mainString);//green


                                }
                                gl.glPopMatrix();

                            }
                        }


                        //if(waitLater){
                        //    try {
                        //        Thread.sleep(1010,1);
                        //    } catch (InterruptedException e) {
                        //        e.printStackTrace();
                        //    }
                        //    waitLater=false;
                        //}



                        endTimer();



                    }

                    if (menuoption == 99) {
                        gl.glClearColor(1f, 1f, 1f, 1f);


                        gl.glPushMatrix();
                        {
                            gl.glTranslatef((-0.05f) * aspect, -0.4f, 0);
                            gl.glColor4f(1f, 1f, 1f, 1f);

                            mainString = "MISSION SUCCESS";
                            font.drawFont(0, 0, 0, aspect*0.065f * (float) mainString.length(), 0.2f, mainString);//green


                        }
                        gl.glPopMatrix();


                        //font2.drawString(-570f, -300, "MISSION SUCCESS!!!!!!", Color.green);
                        float r = 0;
                        for (int c4 = 0; c4 < completedMission.length; c4++) {
                            if (completedMission[c4] != 99) {


                                Boolean noRepeat = true;
                                for (int d = 0; d < c4; d++) {
                                    if (completedMission[c4] == completedMission[d]) {
                                        noRepeat = false;
                                    }
                                }
                                if (noRepeat) {
                                    //font2.drawString(-570f, 180+(c4)*100, missionTitles[completedMission[c4]]+"  "+missionUpgradeTitles[missionProgress[completedMission[c4]]-1], Color.green);
                                    //font.drawString(-570f, 180+(c4)*100+70, "REWARD : "+(250*(missionProgress[completedMission[c4]]+1)), Color.green);

                                    gl.glPushMatrix();
                                    {
                                        gl.glTranslatef((-0.1f) * aspect, -1.3f + r, 0);
                                        gl.glColor4f(1f, 1f, 1f, 1f);
                                        mainString = missionTitles[completedMission[c4]] + "  " + missionUpgradeTitles[missionProgress[completedMission[c4]]-1];
                                        //mainString=missionTitles[completedMission[c4]]+"  "+missionUpgradeTitles[1];


                                        font.drawFont(0, 0, 0, aspect*0.05f * (float) mainString.length(), 0.1f, mainString);//green

                                    }
                                    gl.glPopMatrix();

                                    gl.glPushMatrix();
                                    {
                                        gl.glTranslatef((-0.1f) * aspect, -1.4f + r, 0);
                                        gl.glColor4f(1f, 1f, 1f, 1f);
                                        //mainString = "REWARD : " + Integer.toString((250 * (int) Math.pow(2, missionProgress[completedMission[c4]]-1)));
                                        mainString = "REWARD : " + Integer.toString((int)goldFor(3,completedMission[c4],missionProgress[completedMission[c4]]-1));

                                        font.drawFont(0, 0, 0, aspect*0.05f * (float) mainString.length(), 0.1f, mainString);//green


                                    }
                                    gl.glPopMatrix();

                                    r = r + 0.3f;
                                }


                            }
                        }


                    }
                }
                gl.glPopMatrix();
                save();

            }

            allowListeners = true;

            if (option == 1) {
                my = (my -bannerHeight-37);


                Log.d("overview", vz+" "+velocityz+" "+movementInVelocityZ+" "+score+" "+goldThisTurn);
                distanceMod=distanceModFloor+(distanceModBase-distanceModFloor)*(float)Math.pow(distanceModPower,-(double)movementInVelocityZ);
                float timeMod=calculateTimeMod();
                framesWithoutTouch++;
                if(framesWithoutTouch>1){
                    mouseDown=false;
                }else{
                    mouseDown=true;
                }
                if (getRedoBuffers()) {
                    setUpVehicleBuffers();
                    setRedoBuffers(false);
                }


                default_x_vrotspeed = 0.5f +
                        (vehicles[selected_vehicle].getHandling()
                                + vehicles[selected_vehicle].getHandlingPlus()) / 6f;
//////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////
                ////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////
                ////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////
                ////////////////////////////////////////////////////
                //////////////////////////////////////////////////////
                if (pauseMenuActivated == false) {
                    if (goldThisTurn == 0) {
                        vzBeforeFirstGold = vz;//for achievements

                    }
                    if (numberOfPowerUps == 0) {
                        vzBeforeFirstPowerUp = vz;//for achievements
                    }

                    if (vz > Checkpoint2) {
                        PLATINUMAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 3f * CheckpointPLATINUMbonus2;
                        DIAMONDAbundance  = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 6f * CheckpointDIAMONDbonus2;

                    } else if (vz > Checkpoint1) {
                        PLATINUMAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus())  / 3f * CheckpointPLATINUMbonus1;
                        DIAMONDAbundance  = 0 +  (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 6f * CheckpointDIAMONDbonus1;
                    } else {
                        PLATINUMAbundance = 0;
                        DIAMONDAbundance  = 0;
                    }

                    vrotspeed = 0.1f * (vehicles[selected_vehicle].getHandling() + vehicles[selected_vehicle].getHandlingPlus());


                    if (lives < 1) {
                        if (gems < (int) Math.pow(2d, (double) reviveCounter)) {
                            waitFrames=3;
                            Reset();
                        } else {
                            pauseMenuActivated = true;
                            reviveMenuActivated = true;
                            waitFrames=3;
                        }
                    }
                    //gl.glFrustumf(0, Screen_Width, 0, Screen_Height - 200, -100, 100);
                    //Decide on where gold spawn
                    if (pz < (vz - 20f)) {
                        //pz=vz+100f;

                        powerupNumber = (int) Math.ceil(4d * Math.random());
                        pz = vz + 100f+powerUpFrequency - (float) (Math.random()+1f)/2f *distanceDecreasedPerExtraFrequencyNumber* ((float) (5+vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()+frequencyUpgradeNumber*3));
                        if (pz < vz + 500) {
                            pz = vz + 500;//don`t let powerup spawn too near
                        }
                        px = (CV.WidthOfLevels   - (float) Math.random() * CV.WidthOfLevels  * 2f)*0.35f;
                        py = (CV.HeightOfLevels  - (float) Math.random() * CV.HeightOfLevels * 2f)*0.35f;
                    }

                    if (gemZ < (vz - 20f) && vz > 700f) {
                        //pz=vz+100f;

                        gemZ =  vz + 100f+2f*powerUpFrequency - 2f*(float) (Math.random()+1d)/2f *distanceDecreasedPerExtraFrequencyNumber* ((float) (5+vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()+frequencyUpgradeNumber*3));
                        if (gemZ < vz + 500) {
                            gemZ = vz + 500;//don`t let powerup spawn too near
                        }
                        gemX = (CV.WidthOfLevels   - (float) Math.random() * CV.WidthOfLevels  * 2f)*0.35f;
                        gemY = (CV.HeightOfLevels  - (float) Math.random() * CV.HeightOfLevels * 2f)*0.35f;
                    }

                    //The next if statement determines how far away each gold should be spawned
                    //It does not make new coordinates if the gold_object to be respawned is not passed the vehicle.
                    //if ((vz > (lastGoldSpawnPoint - 200f))
                    //        && (gold_object[(goldSpawnNum + 14) % gold_object.length].getZ() < (vz - 10))) {
                    float[] da=new float[4];

                    if(goldPassed==true){

                        lastGoldSpawnPoint = lastGoldSpawnPoint+20f+(float)Math.random()*100f;
                        spawnnum = 2+(int) (Math.random() * 16d);
                        float chosenx = (CV.WidthOfLevels   - (float) Math.random() * CV.WidthOfLevels  * 2f)*0.37f;
                        float choseny = (CV.HeightOfLevels  - (float) Math.random() * CV.HeightOfLevels * 2f)*0.37f;


                        //if (Math.random() > 0.2) {
                        //    skipped = true;
                        //}
                        for (c = 0; c < spawnnum; c++) {

                            goldx[(c + goldSpawnNum) % (gold_object.length)] = chosenx;

                            //if (skipped) {
                            //    goldx[(c + goldSpawnNum) % (gold_object.length)] = goldx[(c + goldSpawnNum) % (gold_object.length)] = 10000f;
                            //}
                            goldy[(c + goldSpawnNum) % (gold_object.length)] = choseny;
                            goldz[(c + goldSpawnNum) % (gold_object.length)] = lastGoldSpawnPoint + (float) c * 3f ;


                            float randNum = (float) Math.random();

                            if (randNum <= (1 - PLATINUMAbundance - DIAMONDAbundance)) {
                                goldValue[(c + goldSpawnNum) % (gold_object.length)] = 1;
                            }else if (randNum < (1  - DIAMONDAbundance) ) {
                                goldValue[(c + goldSpawnNum) % (gold_object.length)] = 2;
                            }
                            else  {
                                goldValue[(c + goldSpawnNum) % (gold_object.length)] = 3;
                            }

                            lastGoldSpawnPoint = goldz[(c + goldSpawnNum) % (gold_object.length)];
                            if((goldSpawnNum+c+1)%gold_object.length==goldLastPassed){
                                spawnnum=c%gold_object.length;
                                goldPassed=false;
                            }
                        }
                        skipped = false;
                        goldSpawnNum = (goldSpawnNum + spawnnum) % gold_object.length;
                        da[0]=goldz[(goldSpawnNum-spawnnum+goldz.length)%goldz.length];
                        da[1]=goldz[(goldSpawnNum-1+goldz.length)%goldz.length];

                        da[2]=goldx[(goldSpawnNum-1+goldz.length)%goldz.length];
                        da[3]=goldy[(goldSpawnNum-1+goldz.length)%goldz.length];





                        float range = 9f;

                        for (int c = 0; c < RX.length; c++) {

                            if (da[2] < RX[c] +rock[c].getWidth(0) + range && da[2] > RX[c] - range) {
                                if (da[3] < RY[c] + range  +rock[c].getHeight(0)&& da[3] > RY[c] - range) {
                                    if (da[1] < RZ[c] + range*6f  +rock[c].getLength(0)&& da[2] > RZ[c] - range*6f) {

                                        RX[c] = (CV.WidthOfLevels   - (float) Math.random() * CV.WidthOfLevels  * 2f)*0.37f;
                                        RY[c] = (CV.HeightOfLevels  - (float) Math.random() * CV.HeightOfLevels * 2f)*0.37f;

                                        if (da[2] < RX[c] +rock[c].getWidth(0) + range && da[2] > RX[c] - range) {
                                            if (da[3] < RY[c] + range  +rock[c].getHeight(0)&& da[3] > RY[c] - range) {
                                                if (da[1] < RZ[c] + range*6f  +rock[c].getLength(0)&& da[2] > RZ[c] - range*6f) {
                                                    RX[c] =+30f;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }






                    //Decide when rockets + BOD spawn


                    if (vz > (rocketspawnlength) * rocketspawnnum*(float)Math.pow(1.1d,(double)rocketspawnnum)+1000f) {

                        spawnnum = (int) ( (float) Math.random() * 3f*(float)Math.pow(1.4d,(double)rocketspawnnum)) + 1;

                        if (spawnnum > rocket.length) {
                            spawnnum = rocket.length;

                        }
                        for (c = 0; c < spawnnum; c++) {
                            rocketWantSpawned[c] = true;
                        }
                        rocketspawnnum++;
                    }

                    if (vz > (((BODspawnlength) * BODspawnnum)*(float)Math.pow(1.1d,(double)BODspawnnum) + 2000f)) {
                        spawnnum =  (int) ( (float) Math.random() * 1f*(float)Math.pow(1.4d,(double)BODspawnnum)) + 1;
                        if (spawnnum > BOD.length) {
                            spawnnum = BOD.length;

                        }
                        for (c = 0; c < spawnnum; c++) {
                            BODWantSpawned[c] = true;
                        }
                        BODspawnnum++;
                    }

                    int ColourChangeInterval = 4;
                    //long startTime = getTime();


           /* boolean up=(Keyboard.isKeyDown(Keyboard.KEY_UP));
            boolean down=(Keyboard.isKeyDown(Keyboard.KEY_DOWN));
            boolean right=(Keyboard.isKeyDown(Keyboard.KEY_RIGHT));
            boolean left=(Keyboard.isKeyDown(Keyboard.KEY_LEFT));
            boolean in=(Keyboard.isKeyDown(Keyboard.KEY_N));
            boolean out=(Keyboard.isKeyDown(Keyboard.KEY_M));
            boolean rr=(Keyboard.isKeyDown(Keyboard.KEY_J));
            boolean rl=(Keyboard.isKeyDown(Keyboard.KEY_K));

            if(up){CameraY=(float) (CameraY-CameraMovement);}
            if(down){CameraY=(float) (CameraY+CameraMovement);}
            if(right){CameraX=(float) (CameraX+CameraMovement);}
            if(left){CameraX=(float) (CameraX-CameraMovement);}
            if(in){CameraZ=(float) (CameraZ+CameraMovement);}
            if(out){CameraZ=(float) (CameraZ-CameraMovement);}
            if(rr){CameraRX=(float) (CameraRX+CameraMovement*5);}
            if(rl){CameraRX=(float) (CameraRX-CameraMovement*5);}
            */
                    //////////////////gl.glLoadIdentity();
                    //gl.glFrustumf(-xaxis, xaxis, -yaxis, yaxis, 0, 0);


                    //
                    //
                    //
                    //
                    //
                    //
                    //glLoadIdentity must go before everything
                    //
                    //
                    //
                    //
                    //
                    //

                    //if ((amountabovecam+vy)>CV.HeightOfLevels-3f){
                    //	amountabovecam=amountabovecam-0.2f;
                    //}
                    if (amountabovecam < 5.0f && ((amountabovecam + vy) < CV.HeightOfLevels)) {

                        amountabovecam = amountabovecam + 0.2f;
                    }

                    //cam.useView(-vx, -vy - cameraheight, -vz + cameradiatancebehind, 0, CameraRX, 0);

                    gl.glTranslatef(vx, -vy - cameraheight, vz - cameradiatancebehind);
                    gl.glRotatef(CameraRX, 0, 1, 0);

                    float prevx = vx;
                    float prevy = vy;
                    float prevz = vz;
                    float preCameraX = CameraX;
		    	/*
		    	 *
		    	 * gui
		    	 *
		    	 *
		    	 */


                    //gl.glPushMatrix();
                    //{
                    //    gl.glColor4f(0.2f, 0.2f, 0.2f, 1f);
                    //    gl.glTranslatef(vx, vy + cameraheight, vz - cameradiatancebehind + 0.005f);
                    //    //glRotatef(cam.getRX(),cam.getX()-10,0,0);
                    //    //	glRotatef(-cam.getRY(),0,-cam.getY()-10,0);
                    //    	/*
                    //    	 * Problem code here
                    //    	 */
//
                    //    //glRotatef(cam.getRZ(),0,0,cam.getZ()-10);
//
                    //    //Top GUI
                    //    //rC.drawWithBuffers(gl, getmGUItopper(), getmStandardRectInd(), 4);
//
//
                    //    /*gl.glPushMatrix();{
//
//
                    //        gl.glTranslatef(0, 0, -0.000001f);
                    //        glBegin(GL_QUADS);{
                    //            gl.glColor4f(0.2f, 0.8f, 0.3f, 1f);
//
                    //		//glVertex2f( -xaxis*0.95f ,yaxis*.65f);
                    //		//glVertex2f( -xaxis*0.95f ,yaxis*0.95f);
                    //		//glVertex2f( -xaxis*0.90f ,yaxis*0.95f);
                    //		//glVertex2f(- xaxis*0.90f ,yaxis*.65f);
//
                    //		//glVertex2f( -xaxis*0.85f ,yaxis*.65f);
                    //		//glVertex2f( -xaxis*0.85f ,yaxis*0.95f);
                    //		//glVertex2f( -xaxis*0.80f ,yaxis*0.95f);
                    //		//glVertex2f( -xaxis*0.80f ,yaxis*.65f);
//
                    //            glVertex2f( -xaxis*0.95f ,yaxis*.65f);
                    //            glVertex2f( -xaxis*0.95f ,yaxis*0.95f);
                    //            glVertex2f( -xaxis*0.90f ,yaxis*0.95f);
                    //            glVertex2f(- xaxis*0.90f ,yaxis*.65f);
//
                    //            glVertex2f( -xaxis*0.85f ,yaxis*.65f);
                    //            glVertex2f( -xaxis*0.85f ,yaxis*0.95f);
                    //            glVertex2f( -xaxis*0.80f ,yaxis*0.95f);
                    //            glVertex2f( -xaxis*0.80f ,yaxis*.65f);
                    //        }glEnd();
//
                    //        glBegin(GL_LINE_LOOP);{
                    //            glVertex2f( -xaxis*0.9993f ,yaxis*.6f);
                    //            glVertex2f( -xaxis*0.9993f ,yaxis*0.988f);
                    //            glVertex2f( -xaxis*0.7499f ,yaxis*0.988f);
                    //            glVertex2f( -xaxis*0.7499f ,yaxis*.6f);
//
                    //        }glEnd();
//
                    //    }
                    //    gl.glPopMatrix();
                    //*/
                    //}
//
                    //gl.glPopMatrix();
//
//
                    //gl.glPushMatrix();
                    //{
//
//
                    //    gl.glTranslatef(vx + xaxis * 0.72f, vy + cameraheight - yaxis * 0.62f, vz - cameradiatancebehind + 0.004f);
//
//
                    //    gl.glPushMatrix();
                    //    {
                    //        gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
                    //        rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 21);
                    //    }
                    //    gl.glPopMatrix();
                    //    gl.glPushMatrix();
                    //    {
                    //        gl.glTranslatef(magcounterx / -16f, magcountery / 16f, -0.00001f);
                    //        gl.glColor4f(0.8f, 0.3f, 0.2f, 1);
                    //        rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 21);
                    //    }
                    //    /*
//
                    //    glBegin(GL_TRIANGLES);{
                    //        float radius=0.15f;
                    //        float xvector;
                    //        float prevxvector=0f;
                    //        float yvector;
                    //        float prevyvector=0f;
//
                    //        int stacks=100;
//
//
                    //        for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                    //            gl.glColor4f(0.5f, 0.4f, 0.5f, 1f);
                    //            glVertex2f(0,0);
                    //            xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                    //            yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
//
                    //            gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
                    //            glVertex2f(prevxvector,prevyvector);
                    //            glVertex2f(xvector,yvector);
                    //            prevxvector=xvector;
                    //            prevyvector=yvector;
//
                    //        }
//
                    //        prevxvector=0f;
                    //        prevyvector=0f;
//
                    //        for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                    //            gl.glColor4f(0.5f, 0.4f, 0.5f, 1f);
                    //            glVertex2f(0, 0);
                    //            xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                    //            yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
//
                    //            gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
                    //            glVertex2f(prevxvector, -prevyvector);
                    //            glVertex2f(xvector, -yvector);
                    //            prevxvector=xvector;
                    //            prevyvector=yvector;
                    //        }
//
                    //    }glEnd();
                    //    */
//
//
                    //    /*
                    //    gl.glPushMatrix();{
                    //        gl.glTranslatef(magcounterx / -16f, magcountery / 16f, -0.00001f);
                    //        gl.glColor4f(0.8f, 0.3f, 0.2f, 1);
                    //        glBegin(GL_TRIANGLES);{
                    //            float radius=0.05f;
                    //            float xvector;
                    //            float prevxvector=0f;
                    //            float yvector;
                    //            float prevyvector=0f;
//
                    //            int stacks=100;
//
//
                    //            for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                    //                glVertex2f(0,0);
                    //                xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                    //                yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
//
//
                    //                glVertex2f(prevxvector,prevyvector);
                    //                glVertex2f(xvector,yvector);
                    //                prevxvector=xvector;
                    //                prevyvector=yvector;
//
                    //            }
//
                    //            prevxvector=0f;
                    //            prevyvector=0f;
//
                    //            for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                    //                glVertex2f(0,0);
                    //                xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                    //                yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
//
//
                    //                glVertex2f(prevxvector,-prevyvector);
                    //                glVertex2f(xvector,-yvector);
                    //                prevxvector=xvector;
                    //                prevyvector=yvector;
                    //            }
//
                    //        }glEnd();
                    //    }
                    //    gl.glPopMatrix();
//
                    //   */
//
                    //}
                    //gl.glPopMatrix();
//
//
                    //glOrtho(0,Display.getWidth(),0,Display.getHeight(), -100,100);

                    //cam.useView(CameraX,CameraY,-CameraZ,CameraRX);



                    //if(-h%ColourChangeInterval>ColourChangeInterval/2){glClearColor(1,0,0,1);}else{glClearColor(0,1,0,1);}

                    if (mouseDown) {

                        if (Screen_Height / 100 * 0 < my && Screen_Height / 100 * 20 > my && Screen_Height / 100 * 0 < omy && Screen_Height / 100 * 20 > omy) {
                            if (Screen_Width / 100 * 75 < mx && Screen_Width > mx && Screen_Width / 100 * 75 < omx && Screen_Width > omx) {

                                pauseMenuActivated = true;
                            }

                        }

                        if (Screen_Width / 100 * 75 > mx ) {


                            if (Screen_Height / 100 * 0 < my && Screen_Height / 100 * 10 > my ) {
                                m1=10f*mx/(Screen_Width / 100 * 75)-(10f*mx/(Screen_Width / 100 * 75))%1f;
                            }
                            if (Screen_Height / 100 * 10 < my && Screen_Height / 100 * 20 > my ) {
                                m2=10f*mx/(Screen_Width / 100 * 75)-(10f*mx/(Screen_Width / 100 * 75))%1f;
                            }
                        }
                    }
                    //if(CameraZ>z1){
                    //presentstage++;
                    //x1=CV.LengthOfLevels*presentstage;
                    //x2=CV.LengthOfLevels*(presentstage+1);
                    //}


                    // Ceiling_plain c1=new Ceiling_plain(CV.HeightOfLevels/2,0,true);


                    for (c = 0; c < rock.length; c++) {
                        Boolean test = RZ[c] < (vz - 10f);


                        if (test) {

                            if(c%4!=0) {
                                RX[c] = 1.1f * (float) Math.random() * CV.WidthOfLevels - CV.WidthOfLevels / 2;
                                RY[c] = 1.1f * (float) Math.random() * CV.HeightOfLevels - CV.HeightOfLevels / 2;
                                RZ[c] = vz + 1000 + (float) Math.random() * distanceMod;

                            }else{
                                RX[c] = vx+0.4f * (float) Math.random() * CV.WidthOfLevels - CV.WidthOfLevels   / 5;
                                RY[c] = vy+0.4f * (float) Math.random() * CV.HeightOfLevels - CV.HeightOfLevels / 5;
                                RZ[c] = vz + 300  + (float) Math.random() * distanceMod*0.5f;

                            }
                            //float range = 15f;
                            //for (int d = 0; d < goldz.length; d++) {
                            //    if         (RX[c] < (goldx[d] + range) && RX[c] > (goldx[d] - range)) {
                            //        if     (RY[c] < (goldy[d] + range) && RY[c] > (goldy[d] - range)) {
                            //            if (RZ[c] < (goldz[d] + range) && RZ[c] > (goldz[d] - range)) {
                            //                RX[c]=RX[c]+25f;
                            //                RY[c]=RY[c]+25f;
                            //            }
                            //        }
                            //    }
                            //}
                        }




                        rock[c].Render(gl, RX[c], RY[c], RZ[c]);


                    }

                    //vehicle

    			/*
    			 *
    			 * control keys
    			 */

    			/*
    			 * FOR KEYPAD

    			boolean vehicleup=(Keyboard.isKeyDown(Keyboard.KEY_W));
	    		boolean vehicledown=(Keyboard.isKeyDown(Keyboard.KEY_S));
	    		boolean vehicleright=(Keyboard.isKeyDown(Keyboard.KEY_D));
	    		boolean vehicleleft=(Keyboard.isKeyDown(Keyboard.KEY_A));

	    		if(vehicleright){
		    		xrot=xrot-vrotspeed;
		    		if (xrot<-rotlimit){
		    			xrot=-rotlimit;
		    		}
		    	}

		    	if(vehicledown){
		    		yrot=yrot-vrotspeed;
		    		if (yrot<-rotlimit){
		    			yrot=-rotlimit;
		    		}
		    	}

		    	if(vehicleleft){
		    		xrot=xrot+vrotspeed;
		    		if (xrot>rotlimit){
		    			xrot=rotlimit;
		    		}
		    	}

		    	if(vehicleup){
		    		yrot=yrot+vrotspeed;
		    		if (yrot>rotlimit){
		    			yrot=rotlimit;}
		    			}
		    	 */



            /*if (in){
                zmov=zmov+0.1f;
            }
            if (in){
                zmov=zmov-0.1f;
            }
            */

    			/*
    			 *
    			 * FOR TOUCH
    			 *
    			 */

                    //xaxis*0.72f --- 14% right

                    //yaxis*0.62f --- 19% up


                    // if (mouseDown) {





/*
                    //magcounterx = ((float) mx - (float) Screen_Width * 0.14f) / 40f;
                    //magcountery = ((float) my - (float) Screen_Height * 0.19f) / 40f;
                    //magcounterx = ((float)mx-(float)fmx) / 40f;
                    //magcountery = ((float)my-(float)fmy) / 40f;
                    magcounterx = ((float) mx - (float) fmx) / 40f;
                    magcountery = ((float) my - (float) fmy) / 40f;
                    if (magcounterx > 2) {

                        magcounterx = 2;
                    }
                    if (magcounterx < -2) {

                        magcounterx = -2;
                    }
                    if (magcountery > 2) {

                        magcountery = 2;
                    }
                    if (magcountery < -2) {

                        magcountery = -2;
                    }


                    /////////////////Is this relevant??? I dunno.
                    if (magcounterx > 0) {
                        amountOfFramesSteeringLeft = amountOfFramesSteeringLeft + 1;
                        amountOfFramesSteeringRight = 0;
                    }
                    if (magcounterx < 0) {

                        amountOfFramesSteeringRight = amountOfFramesSteeringRight + 1;
                        amountOfFramesSteeringLeft = 0;
                    }
                    if (magcountery > 0) {

                        amountOfFramesSteeringUp = amountOfFramesSteeringUp + 1;
                        amountOfFramesSteeringDown = 0;
                    }
                    if (magcountery < 0) {

                        amountOfFramesSteeringDown = amountOfFramesSteeringDown + 1;
                        amountOfFramesSteeringUp = 0;
                    }


                    //    vrotspeed= (float) Math.pow((double)
                    //    		(1f
                    //		+
                    //	((vehicles[selected_vehicle].getHandling()
                    //+vehicles[selected_vehicle].getHandlingPlus()))/rotlimit/200f
                    //   		)
                    //    		,(double)(xrot/rotlimit));
                    //


                    if (xrot > rotlimit / 2f) {

                        vrotspeed = default_x_vrotspeed * 2f;

                    } else if (xrot < -rotlimit / 2f) {

                        vrotspeed = default_x_vrotspeed * 2f;

                    } else {
                        //vrotspeed=default_x_vrotspeed/1.5f;
                        vrotspeed = default_x_vrotspeed * (bonusvxrotspeed * (float) (amountOfFramesSteeringRight + amountOfFramesSteeringLeft) / (float) amountOfFramesSteeringLeftUntilBonus + vehicles[selected_vehicle].getHandling() + vehicles[selected_vehicle].getHandlingPlus());
                        vrotspeed = vrotspeed - vrotspeed * xrot / (rotlimit * 1.5f);
                    }


                    if (yrot > rotlimit / 2f) {

                        vrotspeed = default_y_vrotspeed * 2f;

                    } else if (yrot < -rotlimit / 2f) {

                        vrotspeed = default_y_vrotspeed * 2f;

                    } else {
                        //vrotspeed=default_x_vrotspeed/1.5f;
                        vrotspeed = default_y_vrotspeed * (bonusvxrotspeed * (float) (amountOfFramesSteeringRight + amountOfFramesSteeringLeft) / (float) amountOfFramesSteeringLeftUntilBonus + vehicles[selected_vehicle].getHandling() + vehicles[selected_vehicle].getHandlingPlus());
                        vrotspeed = vrotspeed - vrotspeed * yrot / (rotlimit * 1.2f);
                    }

                    xrot = xrot - magcounterx * vrotspeed;
                    yrot = yrot - magcountery * vrotspeed;


                    if (xrot < -rotlimit) {
                        xrot = -rotlimit;
                    }
                    if (xrot > rotlimit) {
                        xrot = rotlimit;
                    }
                    if (yrot < -rotlimit) {
                        yrot = -rotlimit;
                    }
                    if (yrot > rotlimit) {
                        yrot = rotlimit;
                    }
                }


                float madeupx = xrot * xTCSpeed;
                float madeupy = yrot * yTCSpeed;




                vx = vx + madeupx;
                vy = vy + madeupy;


                */


                    //////////////////////////////////////////////////////////////////////////////////////////////////////



                /*
                fmx=(int)Screen_Width/2;
                fmy=(int)Screen_Height/10*7;//  Screen_Height/5*3


                float handling_ability=(0.2f+
                        (vehicles[selected_vehicle].getHandling()+vehicles[selected_vehicle].getHandlingPlus())/2f)/10f;


                default_x_vrotspeed=1f;
                if (Math.abs((int)(mx-fmx))<80) {
                    magcounterx = ((float) mx - (float) fmx) / 80f;
                }else{
                    magcounterx = 80f/80f *
                            (float)((mx-fmx)/Math.abs((int)(mx-fmx)));   //+ or -
                }
                xrot=-1f*((1-handling_ability)*magcounterx*rotlimit+handling_ability*xrot);
                if (xrot < -rotlimit) {xrot = -rotlimit;}
                if (xrot >  rotlimit) {xrot =  rotlimit;}
                float madeupx = xrot * xTCSpeed;


                default_y_vrotspeed=1f;
                if (Math.abs((int)(my-fmy))<80) {
                    magcountery = ((float) my - (float) fmy) / 80f;
                }else{
                    magcountery = 80f/80f *
                            (float)((my-fmy)/Math.abs((int)(my-fmy)));   //+ or -
                }
                yrot=-1f*((1-handling_ability)*magcountery*rotlimit+handling_ability*yrot);
                if (yrot < -rotlimit) {yrot = -rotlimit;}
                if (yrot >  rotlimit) {yrot =  rotlimit;}

                float madeupy = yrot * yTCSpeed;

                vx = vx + madeupx;
                vy = vy + madeupy;*/

                    if (false) {
                        steer.simple();

                    } else {
                        //steer.gravity();
                        //steer.gravity(m1,m2);
                        steer.nogravity(m1,m2);

                    }
                    /////////////////////////////////////////////////////////////////////////////////////////////////////


                    //Meteor met=new Meteor(vz+40);
/*
            Wall_plain w1 = new Wall_plain(gl,z1, false);
            Wall_plain w2 = new Wall_plain(gl,z1, true);
            Wall_plain w3 = new Wall_plain(gl,z2, false);
            Wall_plain w4 = new Wall_plain(gl,z2, true);
            Wall_plain w5 = new Wall_plain(gl,z3, false);
            Wall_plain w6 = new Wall_plain(gl,z3, true);

            Ceiling_plain c1 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z1, false);
            Ceiling_plain c2 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z2, false);
            Ceiling_plain c3 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z3, false);
*/


                /*


                THE LAB


                 */
                    gl.glPushMatrix();
                    {

                        //short[] ve={0,1,20,2,3,20,4,5,20,6,7,20,8,9,20,10,11,20,12,13,20,14,15,20,16,17,20,18,19,20};
                        short[] ve = new short[20 * 3];
                        for (c = 0; c < ve.length / 3; c++) {
                            ve[c * 3] = (short) c;
                            ve[c * 3 + 1] = (short) ((c + 1) % 20);
                            ve[c * 3 + 2] = (short) ((c + 10) % 20);
                        }
                        //float[] re=new float[60];
                        //for(int c=0;c<20*3;c++){
                        //    re[c]=(float)c*0.3f;
                        //}
                        gl.glColor4f(0.5f, 0.5f, 0, 1f);
                        gl.glTranslatef(vx, vy, vz + 16f);
                        gl.glRotatef(a, vx + 1f, vy, vz);
                        //gl.glRotatef(0,0,1,0);

                        //font.drawFont(5f, 0, vz - 5f, 1f * (1f + ((float) (Math.floor(Math.log10((double) fps))))), 1f, Long.toString(fps));
                        a = a + 2f;//a*2f,a*3f,a
                        //rC.drawLineWithBuffers(gl,
                        //        rC.vertexBufferGenerator(VerticesUtil.generateCircle(0, 90, 6f, 20)),
                        //        rC.indexBufferGenerator(ve), 1);

                        //rC.drawLineWithBuffers(gl,
                        //        rC.vertexBufferGenerator(re),
                        //        rC.indexBufferGenerator(ve),1);


                        //rC.drawWithBuffers(gl,rC.vertexBufferGenerator(VerticesUtil.generateSphere(0,0, 4f, 20,20)),
                        //                rC.indexBufferGenerator(VerticesUtil.generateSphereIndices(20,20)),1);
                        //rC.drawWithBuffers(gl,rC.vertexBufferGenerator(VerticesUtil.generateCylinder(0,0,4f,10f,20,20)),
                        //        rC.indexBufferGenerator(VerticesUtil.generateCylinderIndices(20,20)),1);
                    }
                    gl.glPopMatrix();



                    switch(selected_theme) {
                        case 0:
                            theme.renderPlainTheme(gl, vz);
                            break;
                        case 1:
                            if(theme.getPPbought()==true){
                                theme.renderPaperPlaneTheme(gl, vz);
                            }else{
                                theme.renderPlainTheme(gl, vz);

                            }
                            break;
                        default:
                            theme.renderPlainTheme(gl, vz);
                            break;
                    }

                    /*
                    gl.glClearColor(1, 1, 1, 0.8f);
                    w1.Render(gl, z1, false);
                    w2.Render(gl, z1, true );
                    w3.Render(gl, z2, false);
                    w4.Render(gl, z2, true );
                    w5.Render(gl, z3, false);
                    w6.Render(gl, z3, true );

                    c1.Render(gl, -CV.HeightOfLevels / 2, z1, false);
                    c2.Render(gl, -CV.HeightOfLevels / 2, z2, false);
                    c3.Render(gl, -CV.HeightOfLevels / 2, z3, false);
                    if ((vz > (z1 + CV.LengthOfLevels))) {
                        z1 = z1 + CV.LengthOfLevels;
                        z2 = z2 + CV.LengthOfLevels;
                        z3 = z3 + CV.LengthOfLevels;
                        WallsNeedReseting = false;
                    }*/


                    //  Display.update();
                    //Visibles
                    //TC=new The_Cube(vx,vy,vz,xrot,yrot,zrot);
                    // 	vehicles[selected_vehicle]=new ElectricRing(vx,vy,vz,xrot,yrot,zrot);
                    vehicles[selected_vehicle].Render(vx, vy, vz, getXrot(), getYrot(), getZrot());
                    gem.renderGem(gemX, gemY, gemZ);
                    //gem.renderPowerUp(powerupNumber + 3, gemX, gemY, gemZ, true);

                    //vehicles[4].Render(vx, vy, vz, xrot, yrot, zrot);

                    //	ER=new ElectricRing(vx,vy,vz,xrot,yrot,zrot);
                    //motor=new Motor(vx,vy,vz,xrot,yrot,zrot);
                    //SpaceShuttle SS=new SpaceShuttle(vx,vy,vz,xrot,yrot,zrot);

                    if ((pz - vz) < 400) {
                        power[0].renderPowerUp(powerupNumber + 3, px, py, pz, true);


                    }
///TODO

                    //for (c=0;c<power.length;c++){


                    //Gem collision
                    if((gemZ - vz) < 20f) {
                        if (co.Collide_vertices_power(vehicles[selected_vehicle], gem)) {

                            gems++;
                            gemX = gemX + 10000f;
                        }
                    }

                    if((pz - vz) < 20f) {

                        if (co.Collide_vertices_power(vehicles[selected_vehicle], power[0])) {

                        px = px + 2000f - frequencyUpgradeNumber * distanceDecreasedPerExtraFrequencyNumber;
                        if (power[0].getValue() == 4) {
                            goldThisTurn = goldThisTurn + coinsFromChest + ChestUpgradeNumber * extraCoinsFromChestUpgradeNumber;
                            numberOfPowerUps++;

                        } else if (power[0].getValue() == 5) {//INVINCIBILITY     // this used to be speedy
                            collisionsOn = false;
                            effectCanCancel = true;
                            framesUntilNormal = (int)((float)(framesUntilNormalInvincibility + InvincibilityUpgradeNumber * extraFramesUntilNormalInvincibilityUpgradeNumber)/(float)timeMod);
                            powerUpSpeedOn=false;
                            numberOfPowerUps++;
                            //powerUpSpeedOn=true;

                        } else if (power[0].getValue() == 6) {//SPEEDY//this used to be invincibility
                            effectCanCancel = false;
                            framesUntilNormal2 = (int)((float)(framesUntilNormalMagnet+MagnetUpgradeNumber * extraFramesUntilNormalMagnetUpgradeNumber)/(float)timeMod);
                            co.setExtendedAttraction(3f+vehicles[selected_vehicle].getSize()+vehicles[selected_vehicle].getSizePlus());
                            numberOfPowerUps++;
                        } else if (power[0].getValue() == 7) {//MAGNET
                            collisionsOn = false;
                            effectCanCancel = false;
                            framesUntilNormal = (int)((float)(framesUntilNormalSpeedy + SpeedyUpgradeNumber * extraFramesUntilNormalSpeedyUpgradeNumber)/(float)timeMod);
                            powerUpSpeedOn = true;
                            numberOfPowerUps++;
                        } else {
                            goldThisTurn = goldThisTurn + coinsFromChest + ChestUpgradeNumber * extraCoinsFromChestUpgradeNumber;
                            numberOfPowerUps++;

                        }
                        movementInVelocityZ = (movementInVelocityZ-1) * 0.85f+1f;

                    }

                    }


                    float neardist=-1000f;
                    int nPassed=0;
                    for (c = 0; c < gold_object.length; c++) {

                        if(goldz[c] < vz-15f) {
                            nPassed++;
                            if (goldz[c] > neardist ) {
                                goldz[c] = neardist;
                                goldLastPassed = c;
                            }
                        }

                        int value=goldValue[c];
                        switch(value){


                            case 1:
                                gold_object[c].RenderGOLD(goldx[c], goldy[c], goldz[c]);
                                break;

                            case 2:
                                gold_object[c].RenderPLATINUM(goldx[c], goldy[c], goldz[c]);
                                break;

                            case 3:
                                gold_object[c].RenderDIAMOND(goldx[c], goldy[c], goldz[c]);
                                break;

                            default:
                                gold_object[c].RenderGOLD(goldx[c], goldy[c], goldz[c]);
                        }
                        gold_object[c] = new Gold(gl, goldx[c], goldy[c], goldz[c], goldValue[c]);
                        //	if (co.CollideForGold(TC, gold_object[c])){}

                        if (Math.abs(goldz[c] - vz) < 10f) {
                            if (co.Collide_vertices_gold(vehicles[selected_vehicle], gold_object[c])) {
                                if (gold_object[c].value == 1) {
                                    goldThisTurn++;
                                } else if (gold_object[c].value == 2) {
                                    goldThisTurn = goldThisTurn + 2;
                                } else if (gold_object[c].value == 3) {
                                    goldThisTurn = goldThisTurn + 3;
                                } else {
                                    goldThisTurn++;
                                }
                                goldx[c] = goldx[c] + 100f;
                            }
                        }
                    }
                    if(nPassed>20){
                        goldPassed=true;
                    }
                    //Ball of Death Code

                    for (c = 0; c < BOD.length; c++) {
                        //BOD[c] = new BallOfDeath(gl, BODx[c], BODy[c], BODz[c]);
                        BOD[c].Render(BODx[c], BODy[c], BODz[c]);
                        BODx[c] = BODx[c] + timeMod*BODvx[c];
                        BODy[c] = BODy[c] + timeMod*BODvy[c];
                        BODz[c] = BODz[c] + timeMod*BODvz[c];


                        if (BODx[c] > CV.WidthOfLevels / 2f - BallOfDeath.getRadius()) {
                            BODvx[c] = (float) Math.abs((double) BODvx[c]) * -1f;
                            if (BODx[c] > CV.WidthOfLevels / 2f) {
                                //destruct
                            }
                        }
                        if (BODx[c] < -CV.WidthOfLevels / 2f + BallOfDeath.getRadius()) {
                            BODvx[c] = (float) Math.abs((double) BODvx[c]) * 1f;
                            if (BODx[c] > CV.WidthOfLevels / 2f) {
                                //destruct
                            }
                        }
                        if (BODy[c] > CV.HeightOfLevels / 2f - BallOfDeath.getRadius()) {
                            BODvy[c] = BODvy[c] - 0.2f;
                            if (BODy[c] > CV.HeightOfLevels / 2f - 4f) {
                                //destruct
                            }
                        }

                        if (BODy[c] < -CV.HeightOfLevels / 2 + BallOfDeath.getRadius()) {
                            BODvy[c] = (float) Math.abs((double) BODvy[c]) * 1f;
                            if (BODy[c] > CV.HeightOfLevels / 2f - 4f) {
                                //destruct
                            }
                        }

                        if (vz > 0) {


                            inAttackMode[c] = true;


                            if (BODWantSpawned[c]) {
                                // BODvx[c]=(float)Math.random()*2f-1f;
                                // BODvy[c]=(float)Math.random()*2f-1f;
                                float[] Coords = new float[3];
                                Coords = SpawnRockets();
                                BODx[c] = Coords[0];
                                BODy[c] = Coords[1];
                                BODz[c] = Coords[2];

                                BODWantSpawned[c] = false;

                            }
                        }


                    }


                    //rocket

                    for (c = 0; c < rocket.length; c++) {
                        //rocket[c] = new Rocket(gl, rocketx[c], rockety[c], rocketz[c]);
                        rocket[c].Render(rocketx[c], rockety[c], rocketz[c]);

                        rocketx[c] = rocketx[c] + timeMod*rocketvx[c];
                        rockety[c] = rockety[c] + timeMod*rocketvy[c];
                        rocketz[c] = rocketz[c] + timeMod*rocketvz[c];

                        float rocketAcceleration=0.001f;
                        if ((vx > rocketx[c]) || (vx < rocketx[c])) {

                            rocketvx[c] = rocketvx[c] - timeMod*(rocketx[c] - vx) *rocketAcceleration;

                        }
                        if (vy > rockety[c] || vy < rockety[c]) {

                            rocketvy[c] = rocketvy[c] - timeMod*(rockety[c] - vy) *rocketAcceleration;

                        }

                        if (rocketx[c] > CV.WidthOfLevels / 2f -rocket[c].getRadius()) {
                            rocketvx[c] = (float) Math.abs((double) rocketvx[c]) * -0.4f;
                            rocketx[c] = rocketx[c];
                            if (rocketx[c] > CV.WidthOfLevels / 2f) {
                                //destruct
                            }
                        }
                        if (rocketx[c] < -CV.WidthOfLevels / 2f + rocket[c].getRadius()) {
                            rocketvx[c] = (float) Math.abs((double) rocketvx[c]) * 0.4f;

                            rocketx[c] = rocketx[c];
                            if (rocketx[c] > CV.WidthOfLevels / 2f) {
                                //destruct
                            }
                        }
                        if (rockety[c] > CV.HeightOfLevels / 2f -rocket[c].getRadius()) {
                            rocketvy[c] = rocketvy[c] - 0.2f;
                            if (rockety[c] > CV.HeightOfLevels / 2f - 4f) {
                                //destruct
                            }
                        }

                        if (rockety[c] < (-CV.HeightOfLevels / 2 +rocket[c].getRadius())) {
                            rocketvy[c] = (float) Math.abs((double) rocketvy[c]) * 0.4f;
                            rockety[c] = rockety[c] + rocketvy[c];
                            if (rockety[c] > CV.HeightOfLevels / 2f - 4f) {
                                //destruct
                            }
                        }

                        if (inAttackMode[c]) {
                            rocketvz[c] = rocketvz[c] - 0.00000005f;
                        }
                        if (vz > 0) {
                            inAttackMode[c] = true;


                            if ((rocketWantSpawned[c]) //|| (respawneverything[c] == true)
                             ) {
                                respawneverything[c] = false;
                                rocketvz[c] = (float) Math.random() * -2f - 5f;
                                float[] Coords = new float[3];
                                Coords = SpawnRockets();
                                rocketx[c] = Coords[0];
                                rockety[c] = Coords[1];
                                rocketz[c] = Coords[2];

                                //rocket[c].setRadius(5f*rocket[c].getSize());
                                rocketWantSpawned[c] = false;

                            }
                        }
                    }


				/*
				 * COLLISIONS
				 */

                    if (framesUntilNormal2<0) {
                        co.setExtendedAttraction(2f+0.5f*(vehicles[selected_vehicle].getLuck()+vehicles[selected_vehicle].getLuckPlus()));
                    } else {
                        framesUntilNormal2 = framesUntilNormal2 - 1;

                        for(int c=0;c<goldx.length;c++){
                            if(goldz[c] - vz < 150f && goldz[c] - vz>3f) {
                                if (Math.abs(goldx[c] - vx) < 2) {
                                    goldx[c] = vx;
                                } else {
                                    if(goldx[c]<vx){
                                        goldx[c] = goldx[c]+0.5f*timeMod;
                                    }else{
                                        goldx[c] = goldx[c]-0.5f*timeMod;

                                    }
                                    goldx[c] = goldx[c] + 0.2f*timeMod*(vx-goldx[c]);
                                }

                                if (Math.abs(goldy[c] - vy) < 2) {
                                    goldy[c] = vy;
                                } else {
                                    if(goldy[c]<vy){
                                        goldy[c] = goldy[c]+0.5f*timeMod;
                                    }else{
                                        goldy[c] = goldy[c]-0.5f*timeMod;

                                    }
                                    goldy[c] = goldy[c] + 0.2f*timeMod*(vy-goldy[c]);
                                }

                                if (Math.abs(goldz[c] - vz) < 2) {
                                    goldz[c] = vz;
                                } else {
                                    if(goldz[c]<vz){
                                        goldz[c] = goldz[c]+0.5f*timeMod;
                                    }else{
                                        goldz[c] = goldz[c]-0.5f*timeMod;

                                    }

                                    goldz[c] = goldz[c] + 0.2f*timeMod*(vz-goldz[c]);
                                }
                            }
                        }

                    }

                    if(effectCanCancel){
                            for (c = 0; c < rock.length; c++) {

                                if (Math.abs(RZ[c] - vz) < 10f) {
                                    if (co.Collide_vertices_cube(vehicles[selected_vehicle], rock[c],gl)) {
                                        framesUntilNormal = framesUntilNormal-(int)(150f/timeMod);
                                        RX[c] = RX[c] + 1000f;
                                    }
                                }
                            }
                            for (c = 0; c < rocket.length; c++) {

                                if ((Math.abs(rocketz[c] - vz) < 20f)) {//this distance at which collisions are tested must be reasonably high or else will not work
                                    if (co.collide_vertices_rocket(vehicles[selected_vehicle], rocket[c])) {
                                        framesUntilNormal = framesUntilNormal-(int)(300f/timeMod);
                                        rocketx[c] = rocketx[c] + 1000f;

                                    }
                                }
                            }
                            for (c = 0; c < BOD.length; c++) {

                                if (Math.abs(BODz[c] - vz) < BOD[c].getRadius() * 1.5f) {
                                    if (co.collide_vertices_BOD(vehicles[selected_vehicle], BOD[c])) {
                                        framesUntilNormal = framesUntilNormal-(int)(150f/timeMod);
                                        BODx[c] = BODx[c] + 1000f;

                                    }
                                }
                            }

                    }

                    if (collisionsOn) {



                        framesUntilNormal = 400 + framesUntilCollisionsNormalPlus;
                        powerUpSpeedOn = false;
                        if(true) {
                            for (c = 0; c < rock.length; c++) {

                                if (Math.abs(RZ[c] - vz) < 10f) {
                                    if (co.Collide_vertices_cube(vehicles[selected_vehicle], rock[c],gl)) {
                                        RX[c] = RX[c] + 1000f;
                                        lives = lives - 1;

                                    }
                                }
                            }
                            for (c = 0; c < rocket.length; c++) {

                                if ((Math.abs(rocketz[c] - vz) < 20f)) {//this distance at which collisions are tested must be reasonably high or else will not work
                                    if (co.collide_vertices_rocket(vehicles[selected_vehicle], rocket[c])) {
                                        rocketx[c] = rocketx[c] + 1000f;
                                        lives = lives - 1;

                                    }
                                }
                            }
                            for (c = 0; c < BOD.length; c++) {

                                if (Math.abs(BODz[c] - vz) < BOD[c].getRadius() * 1.5f) {
                                    if (co.collide_vertices_BOD(vehicles[selected_vehicle], BOD[c])) {
                                        BODx[c] = BODx[c] + 1000f;
                                        lives = lives - 1;
                                    }
                                }
                            }
                        }
                    } else {
                        gl.glPushMatrix();
                        gl.glEnable(GL10.GL_BLEND);
                        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
                        gl.glColor4f(0.2f, 0.2f, 0.7f, 1f * ((float) framesUntilNormal / 400f));
                        gl.glTranslatef(vx, vy + 0.01f, vz - 0.01f);


                        gl.glRotatef(xrot, 0, 1, 0);
                        gl.glRotatef(yrot, 1,0,0);
                        gl.glRotatef(zrot, 0,0,1);
                        //rC.drawWithBuffers(gl, getmBODVerts(), getmBODInd(), 1);

                        //rC.drawWithBuffers(gl, rC.vertexBufferGenerator(VerticesUtil.generateSphere(0,0,5f,8,8)), rC.indexBufferGenerator(VerticesUtil.generateSphereIndices(8,8)), 1);

                        //VerticesUtil.renderSphere(gl,rC,2f,0.75f,8f,16,16);
                        rC.drawWithBuffers(gl,getmVehicleShieldVerts(), getmVehicleInd(), 36);

                        //Sphere sphere=new Sphere();
                        //sphere.draw(vehicles[selected_vehicle].getLength()/1.5f, 40, 40);

                        gl.glDisable(GL10.GL_BLEND);
                        gl.glPopMatrix();
                        framesUntilNormal = framesUntilNormal - 1;

                        if (effectCanCancel == true) {

                            //	framesUntilNormal=-1;
                        }
                        if (powerUpSpeedOn == true && framesUntilNormal > 50) {

                            float lastvz=vz;

                            vz = vz + timeMod*velocityz*2.5f;


                            if(Math.abs(lastvz-vz)>1000000f){
                                vz=lastvz;
                                lives=0;

                            }
                        }
                        if (framesUntilNormal < 0) {
                            collisionsOn = true;

                        }


                    }


                /*
                if (vx > CV.WidthOfLevels / 2 - 6.5f) {
                    vx = CV.WidthOfLevels / 2 - 6.5f;
                    if (xrot > 2f) {
                        xrot = xrot - 2f;
                    }
                }
                if (vx < -(CV.WidthOfLevels / 2 - 4f)) {
                    vx = -CV.WidthOfLevels / 2 + 4f;
                    if (xrot < -2f) {
                        xrot = xrot + 2f;
                    }
                }
                if (vy > CV.HeightOfLevels / 2 - 2f) {
                    yrot =  - 4f;
                    if (yrot > 1f) {
                        yrot = yrot - 1.5f;
                    }
                    vy = vy-2f;


                }
                if (vy < -(CV.HeightOfLevels / 2 - 4.5f)) {
                    vy = -CV.HeightOfLevels / 2 + 4f;
                    if (yrot < -2f) {
                        yrot = yrot + 2f;
                    }
                    //my=my+1;
                }*/


                    float bounceModifier = 0.7f;
                    if (vx > CV.WidthOfLevels / 2 - 4f) {
                        vx = CV.WidthOfLevels / 2 - 3.99f;
                        setVelx(-bounceModifier * Math.abs(getVelx()));
                        //velx = velx -0.001f*bounceModifier;

                    }
                    if (vx < -CV.WidthOfLevels / 2 + 4f) {
                        vx = -CV.WidthOfLevels / 2 + 3.99f;
                        setVelx(bounceModifier * Math.abs(getVelx()));
                        //velx = velx +0.001f*bounceModifier;
                    }
                    if (vy > (CV.HeightOfLevels / 2-3f)) {

                        setVely(getVely() * 0.5f);
                        //vely = vely-0.005f*bounceModifier;


                        vy = (CV.HeightOfLevels / 2-3f) + (vy - (CV.HeightOfLevels / 2-3f)) * 0.5f-1f;
                    }
                    if (vy < -CV.HeightOfLevels / 2f + 3f) {
                        vy = -CV.HeightOfLevels / 2f + 2.99f;
                        setVely(bounceModifier * Math.abs(getVely()));
                        //vely = vely +0.001f*bounceModifier;

                        //my=my+1;
                    }

                    if (Math.abs(getVelx()) > speedlimit) {
                        setVelx(getVelx() * (Math.abs(getVelx())) / (speedlimit));
                    }

                    if (Math.abs(getVely()) > speedlimit) {
                        setVely(getVely() * (Math.abs(getVely())) / (speedlimit));
                    }
/*
            if (co.Collide_vertices_cuboid(vehicles[selected_vehicle], -CV.WidthOfLevels / 2f - 10f, -100f, vz - 100f, 10f, 200f, vz + 100f)) {


                vx = prevx;
                xrot = xrot + 2f;

            }
            if (co.Collide_vertices_cuboid(vehicles[selected_vehicle], CV.WidthOfLevels / 2f, -100f, vz - 100f, 10f, 200f, vz + 100f)) {
                vx = prevx;
                xrot = xrot - 2f;
            }

            if (co.Collide_vertices_cuboid(vehicles[selected_vehicle], -CV.WidthOfLevels / 2f - 100f, -CV.HeightOfLevels / 2 - 100f, vz - 100f, CV.WidthOfLevels + 200f, 100f, vz + 100f)) {
                yrot = 0.3f * (float) Math.abs((double) yrot) + 1f;

            }
            if (co.Collide_vertices_cuboid(vehicles[selected_vehicle], CV.WidthOfLevels / 2f - 100f, CV.HeightOfLevels / 2, vz - 100f, CV.WidthOfLevels + 200f, 100f, vz + 100f)) {
                yrot = -0.3f * (float) Math.abs((double) yrot) - 0.2f;

            }
*/


                    if (vz > nextMark) {
                        lastMark = nextMark;
                        if (lastMark < 9999) {
                            nextMark = nextMark + 2500;
                            counterPopUp = 0;
                        } else if (lastMark < 29999) {
                            nextMark = nextMark + 5000;
                            counterPopUp = 0;
                        } else {
                            nextMark = nextMark + 10000;
                            counterPopUp = 0;
                        }
                    }


                    //accelerationz = accelerationz * 0.9980f;
                    //velocityz = velocityz + accelerationz;
                    ////velocityz = .
                    //velocityz=5f;
                    float baseV=2f;
                    float turnV=10f;
                    float change=1/25f/60f/2f;
                    change=0.001f;
                    float minutesToTurn=1f;
                    float expectedFPS;
                    if((getFps()<10000&&getFps()>2)){
                        expectedFPS= getFps();                    }else{
                        expectedFPS= 25f/timeMod;                    }
                    movementInVelocityZ=movementInVelocityZ+1/expectedFPS/60f/minutesToTurn*turnV;

                    velocityz=(turnV-baseV)*(float)Math.log10((double)(10*(movementInVelocityZ)/turnV))+baseV;



                    //velocityz=velocityz*1.002f;
                    float lastvz=vz;
                    vz = vz + timeMod*velocityz;


                    if(Math.abs(lastvz-vz)>100000f){
                        //Log.d(TAG,"TimeMod " +Float.toString(timeMod)+
                        //        " vz " +Float.toString(vz)+
                        //        " lastvz " +Float.toString(lastvz)+
                        //        " vel " +Float.toString(velocityz));
                        vz=lastvz;
                        //lives=0;

                    }
                    score = multipler*(vz / 10 + goldThisTurn * 5);
                    //long endTime = getTime();
                    //if (endTime - startTime == 0) {
                    //} else {
                    //    fps = (1000 / (endTime - startTime));
                    //}
                    //fps=84394389;
                    //counter++;

                    gl.glClear(GLES10.GL_DEPTH_BUFFER_BIT);
                    //gl.glEnable(GLES10.GL_BLEND);
                    //gl.glBlendFunc(GLES10.GL_SRC_ALPHA, GLES10.GL_ONE_MINUS_SRC_ALPHA);


                    String output = "T";
                    /*
                    if (lastMark != 0 && counterPopUp < 40) {
                        gl.glPushMatrix();
                        {
                            gl.glColor4f(0, 1, 0, 1);
                            gl.glTranslatef(0.7f * aspect, 1f * 1f, 1);

                            gl.glRotatef(180f, 1, 0, 0);
                            gl.glRotatef(180f, 0, 1, 0);
                            //font.drawString(0, -24, (int) (lastMark / 10f) + "m", Color.blue);
                            font.drawFont(0, 0, 0, 0.2f * (float) output.length(), 0.2f, output);
                        }
                        gl.glPopMatrix();
                        counterPopUp++;
                    }
                    if (score > highScores[9] && highScores[9] + 200f > vz) {
                        gl.glPushMatrix();
                        {
                            gl.glColor4f(0, 1, 0, 1f);
                            gl.glTranslatef(0.7f * aspect, 1f * 1f, 1);
                            gl.glRotatef(180f, 1, 0, 0);
                            gl.glRotatef(180f, 0, 1, 0);
                            //font.drawString(0, -24, "HighScore!!!", Color.yellow);
                            font.drawFont(0, 0, 0, 0.2f * (float) output.length(), 0.2f, output);

                        }
                        gl.glPopMatrix();

                    }*/





/*
            gl.glClear(GLES10.GL_DEPTH_BUFFER_BIT);
            gl.glEnable(GLES10.GL_BLEND);
            gl.glBlendFunc(GLES10.GL_SRC_ALPHA, GLES10.GL_ONE_MINUS_SRC_ALPHA);


            if (lastMark != 0 && counterPopUp < 40) {
                gl.glPushMatrix();
                {
                    gl.glColor4f(0, 1, 0, 1);
                    gl.glTranslatef(vx, vy, vz + 1400 - (float) counterPopUp * 30);
                    gl.glRotatef(180f, 1, 0, 0);
                    gl.glRotatef(180f, 0, 1, 0);
                    //font.drawString(0, -24, (int) (lastMark / 10f) + "m", Color.blue);
                }
                gl.glPopMatrix();
                counterPopUp++;
            }
            if (score > highScores[9] && highScores[9] + 200f > vz) {
                gl.glPushMatrix();
                {
                    gl.glColor4f(0, 1, 0, 1f);
                    gl.glTranslatef(vx, vy, vz + 400f);
                    gl.glRotatef(180f, 1, 0, 0);
                    gl.glRotatef(180f, 0, 1, 0);
                    //font.drawString(0, -24, "HighScore!!!", Color.yellow);
                }
                gl.glPopMatrix();

            }

            gl.glFrustumf(1f, -1f, 1f, -1f, 1f, -0.1f);
            //gl.glOrtho(1,-1,1,-1,1,-0.1);
            gl.glPushMatrix();
            {
                gl.glColor4f(0, 1, 0, 1);
                gl.glTranslatef(-vx + 110, -vy - 170, vz / 1.8177f + 150);
                //font.drawString(-100, 0, "Score:", Color.blue);
                //font.drawString(-100, 25, Integer.toString((int) (score)), Color.blue);
                //font.drawString(-200, 0, "Gold:", Color.decode("0xFFD700"));
                //font.drawString(-200, 25, Integer.toString((int) goldThisTurn), Color.decode("0xFFD700"));
                //font.drawString(-300, 0, "Lives:", Color.yellow);
                //font.drawString(-300, 25, Integer.toString((int) lives), Color.yellow);
            }
            gl.glPopMatrix();
*/
                    gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);

                    gl.glDisable(GL10.GL_DEPTH_TEST);
                    gl.glLoadIdentity();
                    //gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 0.0f, 500.0f);//This is grid used draw at +1 on z-plane

                    //gl.glFrustumf(-1f, 1f, -1.0f, 1.0f, 0.0f, 500.0f);

                    //gl.glLoadIdentity();
                    // gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 0.0f, 500.0f);
                    gl.glRotatef(180f, 0, 1, 0);


                    gl.glPushMatrix();
                    {
                        gl.glColor4f(0.2f, 0.2f, 0.2f, 1f);
                        //gl.glTranslatef(vx, vy + cameraheight, vz - cameradiatancebehind + 0.005f);
                        gl.glTranslatef(0, 0 + 0, 1 - 0 + 0.00005f);


                        //Top GUI
                        rC.drawWithBuffers(gl, getmGUItopper(), getmStandardRectInd(), 4);

                    }

                    gl.glPopMatrix();

                    gl.glPushMatrix();
                    {
                        t = (t + 0.1f) % 5f - 2.5f;
                        gl.glColor4f(0, 1f, 0, 1f);
                        //gl.glTranslatef(vx, vy + cameraheight, vz - cameradiatancebehind + 0.005f);


                        //gl.glTranslatef(2.5f - t, 2.5f - (t*1.5f)%5f, 1 - 0 + 0.0005f);
                        //gl.glTranslatef(-1.10f, 1.61f, 1 - 0 + 0.00000005f);
                        gl.glTranslatef(-2.00f * aspect, 1.61f, 1 - 0 + 0.00000005f);

//109 161

                        //PauseButton
                        rC.drawLineWithBuffers(gl, getmGUIPauseVerts(), getmGUIPauseInd(), 4);

                    }

                    gl.glPopMatrix();


                    gl.glPushMatrix();
                    {
                        gl.glColor4f(0, 1, 0, 1);
                        //gl.glTranslatef(-1f * aspect, 1f * 1f, 1);
                        //font.drawString(-100, 0, "Score:", Color.blue);
                        //font.drawString(-100, 25, Integer.toString((int) (score)), Color.blue);
                        //font.drawString(-200, 0, "Gold:", Color.decode("0xFFD700"));
                        //font.drawString(-200, 25, Integer.toString((int) goldThisTurn), Color.decode("0xFFD700"));
                        //font.drawString(-300, 0, "Lives:", Color.yellow);
                        //font.drawString(-300, 25, Integer.toString((int) lives), Color.yellow);


                        //mView.isInTouchMode()


                        //output =Float.toString (vehicles[selected_vehicle].getVertices()[23]);

                        output = "SCORE:" + Integer.toString((int) score);
                        font.drawFont(aspect * -0.95f, 0.63f, 1.00001f, aspect *0.055f * (float) output.length(), 0.08f, output);
                        output = "GOLD:" + Integer.toString((int) goldThisTurn);
                        font.drawFont(aspect * -0.95f, 0.73f, 1.00001f, aspect *0.055f * (float) output.length(), 0.08f, output);
                        output = "LIVES:" + Integer.toString((int) lives);
                        font.drawFont(aspect * +0.0f, 0.63f, 1.00001f , aspect *0.055f * (float) output.length(), 0.08f, output);
                        output = "GEMS:" + Integer.toString(gems);
                        font.drawFont(aspect * +0.0f, 0.73f, 1.00001f , aspect *0.055f * (float) output.length(), 0.08f, output);


                        output = message;
                        font.drawFont(aspect * +0.0f, 0.73f, 1.00001f, 0.04f * (float) output.length(), 0.08f, output);


                    }
                    gl.glPopMatrix();

                    output = "t";
                    if (lastMark != 0 && counterPopUp <=0) {
                        float size=0.6f-counterPopUp/35f/2f;
                        gl.glPushMatrix();
                        {
                            gl.glColor4f(3/6f, 3/6f, 3/6f, 1f+counterPopUp/35f);

                            //font.drawString(0, -24, (int) (lastMark / 10f) + "m", Color.blue);
                            output = Integer.toString((int) (lastMark / 10f)) + "M";
                            font.drawFont(aspect *-size/2f,-size/2f+0.35f, 1.00001f, aspect *size, size, output);
                        }
                        gl.glPopMatrix();
                        Log.d("debug", "Show : " + Integer.toString((int) counterPopUp));
                        counterPopUp=counterPopUp-timeMod;
                        if(counterPopUp<-35){
                            counterPopUp=1f;
                        }
                    }
                    Log.d("debug",Float.toString(vz/10f));
                    if (counterPopUp2>-35&&score > highScores[9] //&& highScores[9] + 200f > vz
                            ) {
                        gl.glPushMatrix();
                        {
                            float size= 0.6f*-counterPopUp2/35f/2f;
                            gl.glColor4f(3/6f, 3/6f, 3/6f, 1+counterPopUp/35f);
                            //font.drawString(0, -24, "HighScore!!!", Color.yellow);
                            output = "HIGHSCORE";
                            font.drawFont(aspect *-size/2f,-size/2f+0.35f, 1.00001f, aspect*2.3f *size, size, output);
                            counterPopUp2=counterPopUp2-timeMod;

                        }
                        gl.glPopMatrix();

                    }
                    gl.glPushMatrix();
                    {
                        gl.glColor4f(0, 1f, 0, 1f);
                        //gl.glTranslatef(0,0,1.00001f);
                        //font.drawString(-100, 0, "Score:", Color.blue);
                        //font.drawString(-100, 25, Integer.toString((int) (score)), Color.blue);
                        //font.drawString(-200, 0, "Gold:", Color.decode("0xFFD700"));
                        //font.drawString(-200, 25, Integer.toString((int) goldThisTurn), Color.decode("0xFFD700"));
                        //font.drawString(-300, 0, "Lives:", Color.yellow);
                        //font.drawString(-300, 25, Integer.toString((int) lives), Color.yellow);


                        //font.drawFont(aspect * -0.5f, 0.0f, 1.00001f, 0.2f * 2f, 0.1f, "WAZZAH:WHA");

                    }
                    gl.glPopMatrix();

                    gl.glPushMatrix();
                    {
                        gl.glColor4f(0, 1f, 0, 1f);
                        gl.glTranslatef(aspect * -0.5f, 0.5f, 1.00001f);
                        //font.drawString(-100, 0, "Score:", Color.blue);
                        //font.drawString(-100, 25, Integer.toString((int) (score)), Color.blue);
                        //font.drawString(-200, 0, "Gold:", Color.decode("0xFFD700"));
                        //font.drawString(-200, 25, Integer.toString((int) goldThisTurn), Color.decode("0xFFD700"));
                        //font.drawString(-300, 0, "Lives:", Color.yellow);
                        //font.drawString(-300, 25, Integer.toString((int) lives), Color.yellow);

                        int sum = 0;
                        for (int c = 0; c < fpses.length; c++) {
                            sum = sum + fpses[c];
                        }
                        if(debugging) {
                            font.drawFont(aspect * -0.0f, 0, 0, 0.2f * 1f, 0.1f, Long.toString(getFps()));


                            font.drawFont(aspect * -0.0f, 0.1f, 0, 0.2f * 1f, 0.1f, Long.toString(sum / fpses.length));

                        }
                    }
                    gl.glPopMatrix();


                    if (mouseDown == true) {
                        gl.glPushMatrix();
                        {


                            //gl.glTranslatef(vx + xaxis * 0.72f, vy + cameraheight - yaxis * 0.62f, vz - cameradiatancebehind + 0.004f);
                            // gl.glTranslatef(0 + (aspect)*xaxis * 0.67f, 0 + 0 - yaxis * 1.32f, 2 - 0 + 0.00004f);
                            // gl.glTranslatef(0 + (aspect)*xaxis * 2f, 0 + 0 - yaxis * 1.32f, 2 - 0 + 0.00004f);
                            //gl.glTranslatef(0 + (aspect)*1f * 2f-1.25f, 0 + 0 - 1f * 1.32f+0.5f, 2 - 0 + 0.00004f);
                            //gl.glTranslatef(0, 0, 2 - 0 + 0.00004f);

                            // gl.glTranslatef(aspect*1,1/aspect*-1, 2 - 0 + 0.00004f);

                            // gl.glTranslatef(0,0, 1 - 0 - 0.00004f);

                            gl.glPushMatrix();

                            //gl.glTranslatef(0 / -16f, 0 / 16f, -0.0000001f);
                            //gl.glTranslatef((float) -fmx / Screen_Width * aspect*4f+  aspect, (float) -fmy / Screen_Height*4f+1, 2 - 0 + 0.00004f-0.0000001f);
                            gl.glTranslatef(+aspect - 2f * aspect * fmx / Screen_Width, +1 - 2f * 1f * fmy / Screen_Height, 1.0001f);

                            gl.glColor4f(0.5f, 0.5f, 0.5f, 0.3f);
                            rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 20);

                            //rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 20);

                            gl.glPopMatrix();
                            gl.glPushMatrix();

                            //gl.glTranslatef(magcounterx / -16f, magcountery / 16f, -0.00001f);
                            //gl.glTranslatef(-1f+(increaser*2f)%2f,0, -0.999999f);
                            //gl.glTranslatef(-1f+(increaser*2f)%2f,-1f+(increaser*2.5f)%2f, 1f);


                            //gl.glTranslatef((float) //-(mx-fmx) / Screen_Width * aspect*4f+
                            //        -aspect, (float) -(my-fmy) / Screen_Height*4f+1, 2 - 0 + 0.00004f-0.0000001f);

                            //gl.glTranslatef(-aspect, (float)+1, 1);
                            gl.glTranslatef(+aspect - 2f * aspect * steer.getCmx() / Screen_Width, +1 - 2f * 1f * steer.getCmy() / Screen_Height, 1.00001f);
                            //gl.glTranslatef(-1f+(increaser*2f)%2f,0, -0.001f);


                            gl.glColor4f(0.8f, 0.3f, 0.2f, 0.5f);
                            rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 20);
                            //rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 20);


                            gl.glPopMatrix();
                        }
                        gl.glPopMatrix();
                    }
                    gl.glClear(GLES10.GL_DEPTH_BUFFER_BIT);
                    //gl.glEnable(GLES10.GL_BLEND);
                    //gl.glBlendFunc(GLES10.GL_SRC_ALPHA, GLES10.GL_ONE_MINUS_SRC_ALPHA);


                    /*
                    gl.glPushMatrix();
                    {
                        gl.glColor4f(0, 1, 0, 1);
                        gl.glTranslatef(0.1f * aspect, 1f * 1f, 1);
                        //font.drawString(-100, 0, "Score:", Color.blue);
                        //font.drawString(-100, 25, Integer.toString((int) (score)), Color.blue);
                        //font.drawString(-200, 0, "Gold:", Color.decode("0xFFD700"));
                        //font.drawString(-200, 25, Integer.toString((int) goldThisTurn), Color.decode("0xFFD700"));
                        //font.drawString(-300, 0, "Lives:", Color.yellow);
                        //font.drawString(-300, 25, Integer.toString((int) lives), Color.yellow);
                        output = "SCORE  " + Integer.toString((int) (score));
                        font.drawFont(0, 0, 0, 0.05f * (float) output.length(), 0.1f, output);

                        output = "GOLD  " + Integer.toString((int) goldThisTurn);
                        font.drawFont(0, 0, 0, 0.05f * (float) output.length(), 0.1f, output);

                        output = "LIVES  " + Integer.toString((int) lives);
                        font.drawFont(0, 0, 0, 0.05f * (float) output.length(), 0.1f, output);


                    }
                    gl.glPopMatrix();*/


                    gl.glMatrixMode(GLES10.GL_MODELVIEW);
                    //Display.update();
                    //gl.glClear(GLES10.GL_COLOR_BUFFER_BIT);
                    //gl.glClear(GLES10.GL_DEPTH_BUFFER_BIT);
                    gl.glEnable(GLES10.GL_DEPTH_TEST);
                    gl.glDisable(GLES10.GL_BLEND);
                    gl.glEnable(GLES10.GL_TEXTURE_2D);


                }


                if (pauseMenuActivated == true) {

                    my = (int) Screen_Height - my;
                    //my=my+38;
                    gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

                    gl.glLoadIdentity();

                    if (!reviveMenuActivated) {//in other words this is just the normal pause menu
                        gl.glPushMatrix();
                        {
                            gl.glTranslatef(0, 0, -1.000001f);
                            menus.PAUSE_MENU();


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();

                        int textureID = R.drawable.pausemenuhighdef;

                        //menus.PAUSE_MENU();
                        gl.glEnable(GL10.GL_TEXTURE);
                        gl.glColor4f(1f, 1f, 1f, 1f);
                        gl.glTranslatef(0, 0, 0);
                        //rC.drawWithBuffers(gl, this.getmStandardRectVerts(), this.getmStandardRectUVCoordsVerts(), this.getmStandardRectInd(), 6, textureID);
///////////////////////////////////////////////////////////////////////////////TODO
                        gl.glDisable(GL10.GL_TEXTURE);
                        gl.glPopMatrix();
                        ////////////////////////r++;////////////////////////////TODO

                        //Display.update();/////////////////////////////////////////////////


                        gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);
                        gl.glEnable(GL10.GL_DEPTH_TEST);
                        if (mouseDown) {
                            if (menuoption == 0) {

                                if ((float) Screen_Width / 512f * 160f < mx && mx < (float) Screen_Width / 512f * 350f) {
                                    //Resume
                                    if ((float) (Screen_Height) / 512f * 352f < my && my < (float) Screen_Height / 512f * 412f) {

                                        pauseMenuActivated = false;

                                    }

                                    if ((float) (Screen_Height) / 512f * 262f < my && my < (float) Screen_Height / 512f * 322f) {


                                    }


                                    if ((float) (Screen_Height) / 512f * 80f < my && my < (float) Screen_Height / 512f * 140f) {
                                        option = 0;
                                        waitFrames=3;

                                        Reset();
                                        pauseMenuActivated = false;
                                    }

                                }
                            }
                        }

                    } else {
                        //lives = 0;
                        int cost = (int) Math.pow(2d, (double) reviveCounter);


                        gl.glPushMatrix();
                        {
                            gl.glTranslatef(0, 0, -1.000001f);
                            menus.REVIVE_MENU(font, cost);


                        }
                        gl.glPopMatrix();
                        gl.glPushMatrix();


                        gl.glEnable(GL10.GL_TEXTURE);
                        gl.glColor4f(1f, 1f, 1f, 1f);
                        gl.glTranslatef(0, 0, 0);
                        //rC.drawWithBuffers(gl, this.getmStandardRectVerts(), this.getmStandardRectUVCoordsVerts(), this.getmStandardRectInd(), 6, textureID);
///////////////////////////////////////////////////////////////////////////////TODO
                        gl.glDisable(GL10.GL_TEXTURE);
                        gl.glPopMatrix();
                        ////////////////////////r++;////////////////////////////TODO

                        //Display.update();/////////////////////////////////////////////////


                        gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);
                        gl.glEnable(GL10.GL_DEPTH_TEST);

                        if (mouseDown) {
                            if (menuoption == 0&& waitFrames<=0) {


                                if ((float) Screen_Height / 512f * 70f < my && my < (float) Screen_Width / 512f * 203f) {
                                    //do not revive
                                    if ((float) (Screen_Width) / 512f * 102f < mx && mx < (float) Screen_Width / 512f * 240f) {

                                        option = 0;
                                        Reset();
                                        pauseMenuActivated = false;
                                        reviveMenuActivated = false;
                                        startTimer();



                                        //gl.glClearColor(1,1,1,1);

                                    }


                                    //revive
                                    if ((float) (Screen_Width) / 512f * 267f < mx && mx < (float) Screen_Width / 512f * 406f) {

                                        pauseMenuActivated = false;
                                        reviveMenuActivated = false;
                                        lives = 1;
                                        gems = gems - cost;
                                        reviveCounter++;

                                    }

                                }
                            }
                        }
                    }


                }


//////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////
                ////////////////////////////////////////////////////
/*
        gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);

        gl.glDisable(GL10.GL_DEPTH_TEST);
        gl.glLoadIdentity();
        //gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 0.0f, 500.0f);

        gl.glFrustumf(-1f, 1f, -1.0f, 1.0f, 0.0f, 500.0f);

        //gl.glLoadIdentity();
        // gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 0.0f, 500.0f);
        gl.glRotatef(180f, 0, 1, 0);


        gl.glPushMatrix();
        {
            gl.glColor4f(0.2f, 0.2f, 0.2f, 1f);
            //gl.glTranslatef(vx, vy + cameraheight, vz - cameradiatancebehind + 0.005f);
            gl.glTranslatef(0, 0 + 0, 1 - 0 + 0.00005f);



            //Top GUI
            rC.drawWithBuffers(gl, getmGUItopper(), getmStandardRectInd(), 4);

        }

        gl.glPopMatrix();


        gl.glPushMatrix();
        {


            //gl.glTranslatef(vx + xaxis * 0.72f, vy + cameraheight - yaxis * 0.62f, vz - cameradiatancebehind + 0.004f);
            // gl.glTranslatef(0 + (aspect)*xaxis * 0.67f, 0 + 0 - yaxis * 1.32f, 2 - 0 + 0.00004f);
            // gl.glTranslatef(0 + (aspect)*xaxis * 2f, 0 + 0 - yaxis * 1.32f, 2 - 0 + 0.00004f);
            gl.glTranslatef(0 + (aspect)*1f * 2f-1.25f, 0 + 0 - 1f * 1.32f+0.5f, 2 - 0 + 0.00004f);
            // gl.glTranslatef(aspect*1,1/aspect*-1, 2 - 0 + 0.00004f);

            // gl.glTranslatef(0,0, 1 - 0 - 0.00004f);

            gl.glPushMatrix();

            gl.glTranslatef(0 / -16f, 0 / 16f, -0.0000001f);

            gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
            rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 20);

            //rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 20);

            gl.glPopMatrix();
            gl.glPushMatrix();

            //gl.glTranslatef(magcounterx / -16f, magcountery / 16f, -0.00001f);
            //gl.glTranslatef(-1f+(increaser*2f)%2f,0, -0.999999f);
            gl.glTranslatef(-1f+(increaser*2f)%2f,-1f+(increaser*2.5f)%2f, 1f);

            //gl.glTranslatef(-1f+(increaser*2f)%2f,0, -0.001f);


            gl.glColor4f(0.8f, 0.3f, 0.2f, 1);
            rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 20);
            //rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 20);


            gl.glPopMatrix();
        }
        gl.glPopMatrix();
*/
//////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////
                ////////////////////////////////////////////////////
                //////////////////////////////////////////////////////

/*
        //Point to the right vertex buffer
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        mVertexBuffer.position(0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);


        //Get the texture coordinate buffer ready
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTriangleUVBuffer);

        //Get the index buffer ready
        mTriangleBorderIndicesBuffer.position(0);

        //Draw
        gl.glDrawElements(GL10.GL_TRIANGLES, mTriangleBorderIndicesBuffer.capacity() , GL10.GL_UNSIGNED_SHORT, mTriangleBorderIndicesBuffer);
*/
        /*
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,mVertexBuffer);
        gl.glColor4f(0,1f,0,0);

        gl.glDrawElements(GL10.GL_LINES,mNumOfTriangleBorderIndices,GL10.GL_UNSIGNED_SHORT,mTriangleBorderIndicesBuffer);

        */


            }
            framesSinceMouseDown = framesSinceMouseDown + 1;
            nframesSinceMouseDown = nframesSinceMouseDown + 1;

            mouseDownLast = mouseDown;
            //mouseDown = false;

            endTime = System.nanoTime();
            setFps((long) (1000000000f / ((float) endTime - (float) startTime)));
            while (getFps() > 100) {
                endTime = System.nanoTime();
                setFps((long) (1000000000f / ((float) endTime - (float) startTime)));

            }

            fpses[fpc%fpses.length]=(int) getFps();

            fpc++;
            startTime = endTime;
        }
        turnsSinceBackButton=turnsSinceBackButton+1f;
    }
    FontClass font;

    public static void fjkf(int textureName){

        /*gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);	         //  kinda  irrelevant
        mTextureList=new int[1];



        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl.glGenTextures(1, mTextureList, 0);
        gl.glClientActiveTexture(GL10.GL_TEXTURE0);*/

        if(currentTextureName!=textureName) {
            Bitmap b = BitmapFactory.decodeResource(getmContext().getResources(), textureName);

            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, b, 0);
        }

        currentTextureName=textureName;

    }
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        if (run){
            //changeLayout(width, height, false);
            Screen_Height = height;
            Screen_Width  = width;
            gl.glViewport(0, 0, width, height);
            setAspect((float) width / height);
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glFrustumf(-getAspect(), getAspect(), -1.0f, 1.0f, 1f, 500.0f);
            setUpBuffers();
        }
    }

    /*public void changeLayout(float Screen_Width,float Screen_Height,Boolean noads) {
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

    }*/


    private void setAllBuffers(){
        // Set vertex buffer
        float vertexlist[] = {
                -1.0f, 0.0f, -1.0f,  1.0f, 0.0f, -1.0f,  -1.0f, 0.0f, 1.0f,
                1.0f, 0.0f, 1.0f,  0.0f, 2.0f, 0.0f
        };
        setmVertexBuffer(rC.vertexBufferGenerator(vertexlist));
        /*ByteBuffer vbb = ByteBuffer.allocateDirect(vertexlist.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        setmVertexBuffer(vbb.asFloatBuffer());
        getmVertexBuffer().put(vertexlist);
        getmVertexBuffer().position(0);
*/
        // Set triangle border buffer with vertex indices
        //short trigborderindexlist[] = {
        //       4, 0,  4, 1,  4, 2,  4, 3,  0, 1,  1, 3,  3, 2,  2, 0,  0, 3};
        short trigborderindexlist[] = {
                0,1,2,
                3,1,2,
                4,0,1,
                4,0,2,
                4,3,1,
                4,3,2
        };
        setmTriangleBorderIndicesBuffer(rC.indexBufferGenerator(trigborderindexlist));
        /*
        setmNumOfTriangleBorderIndices(trigborderindexlist.length);
        ByteBuffer tbibb = ByteBuffer.allocateDirect(trigborderindexlist.length * 2);
        tbibb.order(ByteOrder.nativeOrder());
        setmTriangleBorderIndicesBuffer(tbibb.asShortBuffer());
        getmTriangleBorderIndicesBuffer().put(trigborderindexlist);
        getmTriangleBorderIndicesBuffer().position(0);*/
    }
    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_BACK:
                onTouchFake();

                turnsSinceBackButton=0;
            break;
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
    }*/
    private int howMany=0;
    public  boolean onTouchEvent (MotionEvent e){
        bannerAdjusted=false;
        framesWithoutTouch=0;
        //if (!mouseDownLast) {
        //    selected_vehicle = (selected_vehicle + 1) % 3;
        //    setUpVehicleBuffers();
        //}

        //e.getAction();

        // e.getPointerId( e.getPointerCount());

        allowNotListeners=false;
        howMany++;
        while((!allowListeners)&&option==0){

            try {
                Thread.sleep(1,1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        float x = e.getX();
        float y = e.getY();

        //if (framesSinceMouseDown < 2)


        //if (!mouseDown) {
        //    fmx = (int) x;
        //    fmy = (int) y;
        //}


        nmx = (int) x;
        nmy = (int) y;
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - mPreviousX;
                float dy = y - mPreviousY;
                mAngleY = (mAngleY + (int) (dx * TOUCH_SCALE_FACTOR) + 360) % 360;
                mAngleX = (mAngleX + (int) (dy * TOUCH_SCALE_FACTOR) + 360) % 360;
                //mAngleX=y%360;
                //mAngleY=x%360;
                break;
        }

        mPreviousX = x;
        mPreviousY = y;



        //framesSinceMouseDown = 0;
        nmouseDown = true;

        allowNotListeners=true;


        //REMEMBER
        return true;

    }

    public void onTouchFake(){
        nmouseDown=true;
        framesWithoutTouch=0;
        nmx=0;
        nmy=0;
        turnsSinceBackButton=0;
    }

    public  boolean onTouch (View v, MotionEvent event){
        //v.isPressed();


        return true;

    }

    public void onUserInteraction (){

    }

    //First declare vertex buffers
    public static FloatBuffer mStandardRectVerts;//
    public static FloatBuffer mWallRectVerts;//
    public static FloatBuffer mWallStripRectVerts;//
    //public FloatBuffer
    public static FloatBuffer mStandardCuboidVerts;//
    public static FloatBuffer mPaperPlaneVerts;//
    public static FloatBuffer mVehicleVerts;//
    public static FloatBuffer mVehicleShieldVerts;//
    public static FloatBuffer mRocketVerts;//
    public static FloatBuffer mBODVerts;//
    public static FloatBuffer mGold1Verts;//
    public static FloatBuffer mGold2Verts;//
    public static FloatBuffer mGold3Verts;//
    public static FloatBuffer mGUItopper;//
    public static FloatBuffer mGUIPauseVerts;//

    public static FloatBuffer mGUIBigCircleVerts;
    public static FloatBuffer mGUILittleCircleVerts;
    public static FloatBuffer mTagVerts;
    public static FloatBuffer mSmallRectVerts;
    public static FloatBuffer mMidRectVerts;
    public static FloatBuffer mIconRectVerts;
    public static FloatBuffer mCeilingVerts;
    public static FloatBuffer mGemVerts;



    //Declare color buffers
    public static FloatBuffer mStandardCuboidColor;//
    public static FloatBuffer mVehicleColor;//
    public static FloatBuffer mPaperPlaneColor;//

    public static FloatBuffer mRocketsColor;//
    public static FloatBuffer mBODColor;//
    // public FloatBuffer mBODColor;
    public static FloatBuffer mGold1Color;//
    public static FloatBuffer mGold2Color;//
    public static FloatBuffer mGold3Color;//
    public static FloatBuffer mGemColor;

    //Declare texture buffers
    public static FloatBuffer mStandardRectUVCoordsVerts;//
    public static FloatBuffer mUVCoordsStandardCuboid;//

    //Declare indices buffers
    public static ShortBuffer mStandardRectInd;//
    public static ShortBuffer mStandardCuboidInd;//
    public static ShortBuffer mPaperPlaneInd;//
    public static ShortBuffer mVehicleInd;//
    public static ShortBuffer mRocketInd;//
    public static ShortBuffer mBODInd;//
    public static ShortBuffer mGold1Ind;//
    public static ShortBuffer mGold2Ind;//
    public static ShortBuffer mGold3Ind;//
    public static ShortBuffer mGUICircleInd;
    public static ShortBuffer mGUIPauseInd;//
    private static ShortBuffer mGemInd;



    public static FloatBuffer mVehicleSecondaryVerts;
    public static FloatBuffer mVehicleSecondaryColor;
    public static ShortBuffer mVehicleSecondaryInd;


    //Say what number of indices

    public float xaxis=1f;
    public float yaxis=1f;


    public void setUpBuffers(){


        xaxis= getAspect();
        yaxis=1f;
        rC.setMR(this);
        CentralisedVariables CV =new CentralisedVariables();

        //Methodology
        //
        //All building blocks of buffers will be got from the appropriate class.
        //renderController methods will be called in the appropriate classes however
        //all buffers will be stored in MyRenderer classs.
        //
        //
        float[] standardRectVerts={
                -getXaxis(), getYaxis(),0,
                -getXaxis(),-getYaxis(),0,
                getXaxis() ,-getYaxis(),0,
                getXaxis() , getYaxis(),0
        };
        float[] standardRectUVCoords={
                0f,0f,
                0f,1f,
                1f,1f,
                1f,0f
        };
        short[] standardRectInd={
                0,1,2,
                2,3,0
        };



        PowerUps powers=new PowerUps();
        setmUVCoordsStandardCuboid(rC.uvBufferGenerator(powers.getUVCoords()));

        setUpGemBuffer();

        setUpVehicleBuffers();


        setUpGOLDBuffers();


        setUpRocketAndBODBuffers();


        setUpCuboidBuffers();
        setUpGUI();



        setmStandardRectVerts(rC.vertexBufferGenerator(standardRectVerts));
        setmStandardRectUVCoordsVerts(rC.uvBufferGenerator(standardRectUVCoords));
        setmStandardRectInd(rC.indexBufferGenerator(standardRectInd));

        Wall_plain w=new Wall_plain();
        w.makeEverything();


        setmWallRectVerts(rC.vertexBufferGenerator(w.getWallVerts()));
        setmWallStripRectVerts(rC.vertexBufferGenerator(w.getWallStripVerts()));
        Ceiling_plain c=new Ceiling_plain();
        c.makeEverything();
        setmCeilingVerts(rC.vertexBufferGenerator(c.getCeilVerts()));


        float[] GUItopper={
                -xaxis*3f,yaxis       ,0,
                xaxis*3f,yaxis       ,0,
                xaxis*3f,yaxis * 0.6f,0,
                -xaxis*3f,yaxis * 0.6f,0

        };

        //setmGUItopper(rC.vertexBufferGenerator(makeFloatVerts(xaxis * 2f, yaxis * 0.4f)));
        setmGUItopper(rC.vertexBufferGenerator(GUItopper));

        Menus menus=new Menus(gl);
        menus.makeAllVerts();
        setmTagVerts(rC.vertexBufferGenerator(menus.getTagVerts()));
        setmSmallRectVerts(rC.vertexBufferGenerator(menus.getSmallRects()));
        setmMidRectVerts(rC.vertexBufferGenerator(menus.getMidSizeRect()));
        setmIconRectVerts(rC.vertexBufferGenerator(menus.getSmallIconVerts()));






    }


    public void setUpGemBuffer(){
        PowerUps power=new PowerUps(gl);
        power.generateGem();
        setmGemVerts(rC.vertexBufferGenerator(power.getGemVerts  ()) );
        setmGemColor(rC.colorsBufferGenerator(power.getGemColors ()) );
        setmGemInd  (rC.indexBufferGenerator (power.getGemIndices()) );

    }

    public void setUpRocketAndBODBuffers(){
        BallOfDeath bod=new BallOfDeath();
        bod.makeEverything();
        setmBODVerts(rC.vertexBufferGenerator(bod.getVertices()));
        setmBODColor(rC.colorsBufferGenerator(bod.getColors()));
        setmBODInd(rC.indexBufferGenerator(bod.getIndices()));


        Rocket boom=new Rocket();

        boom.makeEverything();
        setmRocketVerts(rC.vertexBufferGenerator(boom.getVertices()));
        setmRocketsColor(rC.colorsBufferGenerator(boom.getColors()));
        setmRocketInd(rC.indexBufferGenerator(boom.getIndices()));
    }

    public void setUpGUI(){
        float aspect = Screen_Width / Screen_Height;

        float radiusBig;
        float radiusLittle;
        if(aspect>1){
            radiusBig       =0.25f*1f;
            radiusLittle    =0.15f*1f;
        }else{
            radiusBig       =0.25f*aspect;
            radiusLittle    =0.15f*aspect;
        }
        //float radiusBig       =0.6f;
        //float radiusLittle    =0.25f;
        //float radiusBig       =0.35f;
        //float radiusLittle    =0.15f;
        int sides=20;

        short[] circleIndices=new short[20*3];
        for(int c=0;c<sides;c++){

            circleIndices[c*3+0]=(short)0;
            circleIndices[c*3+1]=(short)((c)%sides+1);
            circleIndices[c*3+2]=(short)((c+1)%sides+1);

        }

        setmGUICircleInd(rC.indexBufferGenerator(circleIndices));


        float[] circleBigVerts   =new float[(sides+1)*3];
        float[] circleLittleVerts=new float[(sides+1)*3];

        float tempx=0f;
        float tempy=0f;


        for (int c=1;c<(sides/2+1);c++){

            tempx=((float)(c*2f-2f-sides/2)/(float)sides*radiusBig*2f);
            tempx=((float)(c*2f-2f-sides/2)/(float)sides*radiusBig*2f);

            tempy=(float)Math.sqrt((double)(radiusBig*radiusBig-tempx*tempx));

            circleBigVerts[c*3+0]=tempx;
            circleBigVerts[c*3+1]=tempy;
            circleBigVerts[c*3+2]=0;

            circleBigVerts[(c+sides/2)*3+0]=-1f*tempx;
            circleBigVerts[(c+sides/2)*3+1]=-1f*tempy;
            circleBigVerts[(c+sides/2)*3+2]=0;

            circleBigVerts[0*3+0]=0f;
            circleBigVerts[0*3+1]=0f;
            circleBigVerts[0*3+2]=0f;
        }





        for (int c=1;c<(sides/2+1);c++){
            tempx=((float)(c*2f-2f-sides/2)/(float)sides*radiusLittle*2f);
            tempy=(float)Math.sqrt((double)(radiusLittle*radiusLittle-tempx*tempx));


            circleLittleVerts[c*3+0]=tempx;
            circleLittleVerts[c*3+1]=tempy;
            circleLittleVerts[c*3+2]=0;

            circleLittleVerts[(c+sides/2)*3+0]=-1f*tempx;
            circleLittleVerts[(c+sides/2)*3+1]=-1f*tempy;
            circleLittleVerts[(c+sides/2)*3+2]=0;

            circleLittleVerts[0*3+0]=0f;
            circleLittleVerts[0*3+1]=0f;
            circleLittleVerts[0*3+2]=0f;
        }


        setmGUIBigCircleVerts(rC.vertexBufferGenerator(circleBigVerts));
        setmGUILittleCircleVerts(rC.vertexBufferGenerator(circleLittleVerts));


        /*float[] Pause={

                xaxis*0.7499f,-yaxis       ,0f,
                xaxis,-yaxis               ,0f,
                xaxis,-yaxis * 0.8f        ,0f,
                xaxis*0.7499f,-yaxis * 0.8f,0f,
                xaxis*0.80f,-yaxis * 0.95f ,0f,
                xaxis*0.80f,-yaxis * 0.85f ,0f,
                xaxis*0.95f,-yaxis * 0.95f ,0f,
                xaxis*0.95f,-yaxis * 0.85f ,0f

        };*/
        float[] Pause={

                xaxis*0.75f+xaxis*0.26f,-yaxis * 1.19f  +yaxis*0.19f,0f,
                xaxis*1.25f+xaxis*0.26f,-yaxis * 1.19f  +yaxis*0.19f,0f,
                xaxis*1.25f+xaxis*0.26f,-yaxis * 0.81f  +yaxis*0.19f,0f,
                xaxis*0.75f+xaxis*0.26f,-yaxis * 0.81f  +yaxis*0.19f,0f,
                xaxis*0.85f+xaxis*0.26f,-yaxis * 1.10f +yaxis*0.19f,0f,
                xaxis*0.85f+xaxis*0.26f,-yaxis * 0.90f +yaxis*0.19f,0f,
                xaxis*1.15f+xaxis*0.26f,-yaxis * 1.10f +yaxis*0.19f,0f,
                xaxis*1.15f+xaxis*0.26f,-yaxis * 0.90f +yaxis*0.19f,0f

        };
        short[] PauseInd={
                0,1,
                1,2,
                2,3,
                3,0,
                4,5,
                6,7
        };

        setmGUIPauseVerts(rC.vertexBufferGenerator(Pause));
        setmGUIPauseInd(rC.indexBufferGenerator(PauseInd));

    }
    public void setUpCuboidBuffers(){

        Rock rockel=new Rock();
        rockel.makeEverything();

        setmStandardCuboidVerts(rC.vertexBufferGenerator(rockel.getVertices()));
        setmStandardCuboidColor(rC.colorsBufferGenerator(rockel.getColors()));
        setmStandardCuboidInd(rC.indexBufferGenerator(rockel.getIndices()));

    }

    float t=0;
    public void setUpVehicleBuffers() {

        //  vehicles[selected_vehicle].
        //setmVehicleVerts(rC.vertexBufferGenerator(vehicles[selected_vehicle].getModelVertArray() ));
        //  setmVehicleColor(rC.colorsBufferGenerator(vehicles[selected_vehicle].getModelColorArray()));
        // setmVehicleInd(rC.indexBufferGenerator(vehicles[selected_vehicle].getModelIndArray()));

        //vehicles[selected_vehicle].makeEverything();


        //setmVehicleVerts(rC.vertexBufferGenerator(standardRectVerts ));
        //setmVehicleColor(rC.colorsBufferGenerator(standardRectUVCoords));
        //setmVehicleInd  (rC.indexBufferGenerator(standardRectInd));



        Vehicles p=vehicles[2];
        //Vehicles p=new PaperPlane();
        p.fixVerts();
        float[] v=p.getModelVertArray().clone();
        float m=2f;
        for(int c=0;c<v.length/3;c++){
            v[c*3+0]=v[c*3+0]*m;
            v[c*3+1]=v[c*3+1]*m;
            v[c*3+2]=v[c*3+2]*m;
        }
        setmPaperPlaneVerts(rC.vertexBufferGenerator(v));
        setmPaperPlaneColor(rC.colorsBufferGenerator(p.getModelColorArray()));
        setmPaperPlaneInd(rC.indexBufferGenerator(p.getModelIndArray()));


        vehicles[selected_vehicle].fixVerts();
        v=vehicles[selected_vehicle].getModelVertArray().clone();
        m=1.01f;
        for(int c=0;c<v.length/3;c++){
            v[c*3+0]=v[c*3+0]*m;
            v[c*3+1]=v[c*3+1]*m;
            v[c*3+2]=v[c*3+2]*m;
        }
        setmVehicleShieldVerts(rC.vertexBufferGenerator(v));

        setmVehicleVerts(rC.vertexBufferGenerator(vehicles[selected_vehicle].getModelVertArray()));
        setmVehicleColor(rC.colorsBufferGenerator(vehicles[selected_vehicle].getModelColorArray()));
        setmVehicleInd(rC.indexBufferGenerator(vehicles[selected_vehicle].getModelIndArray()));

        setmVehicleSecondaryVerts(rC.vertexBufferGenerator(vehicles[selected_vehicle].getModel2()));
        setmVehicleSecondaryColor(rC.colorsBufferGenerator(vehicles[selected_vehicle].getModelColor2()));
        setmVehicleSecondaryInd(rC.indexBufferGenerator(vehicles[selected_vehicle].getModelIndices2()));

    }

    public void setUpGOLDBuffers(){
        Gold gold=new Gold();

        setmGold1Verts(rC.vertexBufferGenerator(gold.getGOLDVerts(1)));
        setmGold2Verts(rC.vertexBufferGenerator(gold.getGOLDVerts(2)));
        setmGold3Verts(rC.vertexBufferGenerator(gold.getGOLDVerts(3)));

        setmGold1Color(rC.colorsBufferGenerator(gold.getGOLDColors(1)));
        setmGold2Color(rC.colorsBufferGenerator(gold.getGOLDColors(2)));
        setmGold3Color(rC.colorsBufferGenerator(gold.getGOLDColors(3)));

        setmGold1Ind(rC.indexBufferGenerator(gold.getGOLDInd(1)));
        setmGold2Ind(rC.indexBufferGenerator(gold.getGOLDInd(2)));
        setmGold3Ind(rC.indexBufferGenerator(gold.getGOLDInd(3)));
    }


    public float[] makeFloatVerts(float length,float height){
        float[] vertArray={
                0,0       ,0,
                0,height  ,0,
                0,height  ,length,
                0,0       ,length
        };
        return vertArray;
    }

    public float[] makeFloatVertsFloor(float width,float height){
        float[] vertArray={
                0    ,0        ,0,
                width,0        ,0,
                width,height   ,0,
                0    ,height   ,0
        };
        return vertArray;
    }




    public float getXaxis() {
        return xaxis;
    }

    public void setXaxis(float xaxis) {
        this.xaxis = xaxis;
    }

    public float getYaxis() {
        return yaxis;
    }

    public void setYaxis(float yaxis) {
        this.yaxis = yaxis;
    }

    public static float[] SpawnRockets(){

        float[] Coords=new float[3];

        Coords[0]=((float)Math.random()*WidthOfLevels*0.9f-WidthOfLevels/2f);
        Coords[1]=((float)Math.random()*HeightOfLevels*0.9f-HeightOfLevels/2f);
        Coords[2]=(float)Math.random()*800f+1200f+vz;

        return Coords;
    }


    public static void calculateMultiplier(){
        multipler= 1f;
        for(int c=0;c<missionProgress.length;c++){
            multipler=multipler+0.2f*(float)(missionProgress[c]);
        }
    }

    public static int calculateMissionObjective(int type,int level){
        int out=0;
        switch(type){
            case 0://distance - runner
                out=(100 + level * 1000)*10;//divide by 10 to convert to metres
                break;
            case 1://score -
                if(level==0) {
                    out = 1000;
                }else{
                    out = (level+1) * (level+1) * 1000;

                }
                break;
            case 2://gold - miser
                out=50 + level * 150;
                break;
            case 3://number of powerups -
                out=1 + level;
                break;
            case 4://distance without powerups - spartan
                out=(500 + level * 500)*10;//divide by 10 to convert to metres
                break;
            default:
                break;
        }
        return out;
    }
    public static void testMissions(){

        for (int h=0;h<selectedMission.length;h++) {
            Boolean missionPassed = false;

            if(selectedMission[h]!=99) {
                int level = missionProgress[selectedMission[h]];
                switch (selectedMission[h]) {

                    case 0:
                        if (vz >= calculateMissionObjective(selectedMission[h],level)) {
                            missionPassed = true;
                        }
                        break;
                    case 1:
                        if (score >= calculateMissionObjective(selectedMission[h],level)) {
                            missionPassed = true;
                        }
                        break;
                    case 2:
                        if (goldThisTurn >= calculateMissionObjective(selectedMission[h],level)) {
                            missionPassed = true;
                        }
                        break;

                    case 3:
                        if (numberOfPowerUps >= calculateMissionObjective(selectedMission[h],level)) {
                            missionPassed = true;
                        }
                        break;
                    case 4:
                        if (vzBeforeFirstPowerUp >= calculateMissionObjective(selectedMission[h],level)) {
                            missionPassed = true;
                        }
                        break;

                    default:
                        missionPassed = false;
                        break;

                }

                if (missionPassed == true) {
                    missionProgress[selectedMission[h]]++;


                    if (completedMission[0] == 99) {
                        completedMission[0] = selectedMission[h];
                    } else if (completedMission[1] == 99) {
                        completedMission[1] = selectedMission[h];
                    } else if (completedMission[2] == 99) {
                        completedMission[2] = selectedMission[h];
                    }
                    //else {completedMission[0] = selectedMission[h];}


                    //gold = gold + 250 *(int)Math.pow (2,level + 1);
                    gold = gold + goldFor(3,0,level);


                    selectedMission[h] = 99;

                }
            }




        }
    }

    public static int pickNewMission(int whichSelectedMission){//only called if there are enough available missions.


        selectedMission[whichSelectedMission]=(int)Math.floor(Math.random()*(missionProgress.length));
        if(selectedMission[whichSelectedMission]==5){
            selectedMission[whichSelectedMission]=4;
        }
        if (selectedMission[whichSelectedMission]==selectedMission[(whichSelectedMission+1)%3]
                ||selectedMission[whichSelectedMission]==selectedMission[(whichSelectedMission+2)%3]
                ||missionProgress[selectedMission[whichSelectedMission]]>=missionUpgradeTitles.length)
        {
            selectedMission[whichSelectedMission]=pickNewMission(whichSelectedMission);
        }
        return selectedMission[whichSelectedMission];
    }

    public static int completedMissions;//different to array, this counts how many mission-types are at max level
    public static int takenMissions;

    public static void calculationMission(){
    //this caluclulates how many missions have already been assigned and how many have reached max level.
        completedMissions=0;
        for(int c=0;c<missionProgress.length;c++){
            if(missionProgress[c]>=missionUpgradeTitles.length){
                completedMissions++;
            }
        }
        takenMissions=0;
        for(int c=0;c<selectedMission.length;c++){
            if(selectedMission[c]!=99){
                takenMissions++;
            }
        }
    }
    public static void resetMissions(){
        calculationMission();
        for (int g = 0; g < selectedMission.length; g++) {

            if (selectedMission[g] == 99) {
                if(missionProgress.length>completedMissions+takenMissions) {
                    selectedMission[g] = pickNewMission(g);
                    calculationMission();
                }
            }
        }
    }
    public static void Reset() {

        testMissions();
        resetMissions();

        calculateMultiplier();

        framesUntilNormal = 0;
        framesUntilNormal2 = 0;
        //goldThisTurn = goldThisTurn;
        gold = gold + (int)(multipler)*goldThisTurn +(int)(multipler* vz / 200f);

        for (int c=0;c<goldz.length;c++){
            goldz[c]=-107f;
        }
        gemZ=-107f;
        pz=-107f;

        ((Menus) menus).setNotDone000(true);
        for (int c = 0; c < respawneverything.length; c++) {
            respawneverything[c] = true;
        }
        reviveCounter=0;
        z1 = 0f;
        goldSpawnNum = 0;
        lastGoldSpawnPoint = -300f;
        BODspawnnum = 0f;
        rocketspawnnum = 0f;
        z2 = LengthOfLevels;
        z3 = LengthOfLevels * 2;
        WallsNeedReseting = true;
        setVelx(0);
        setVely(0);
        //  int b=(int)(vehicles[0].getSizePlus())*10;
        //   int n;
        //  int m;


        save();
        saveRun();


        for (int c = 0; c < RX.length; c++) {
            RX[c] = (float) Math.random() * WidthOfLevels - WidthOfLevels / 2;
            RY[c] = (float) Math.random() * HeightOfLevels - HeightOfLevels / 2;
            RZ[c] = 250 + 30 * c + ((float) Math.random()) * 100;


        }


       /* try {
        //    writer = new FileWriter(scores, true);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            scan = new Scanner(scores);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            writer.append((score + "   " + (vz * 100) + "   " + playername));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
//////////////////////////////////////////////

        goldThisTurn = 0;
        vx = 0;
        vy = 0;
        vz = 0;
        movementInVelocityZ=1.01f;
        score = 0;
        numberOfPowerUps = 0;
        setXrot(0);
        setYrot(0);
        setZrot(0);
        velocityz = 2f;
        accelerationz = 0.01f;
        nextoption = 0;
        lastMark = 0;
        nextMark = 2500f;
        menuoption = 99;
        theme.init(gl);


    }

    public static void ResetMenu(){
        framesUntilNormal=0;
        framesUntilNormal2=0;
        //goldThisTurn=goldThisTurn+(int)vz/100;
        gold = gold + (int)(multipler)*goldThisTurn +(int)(multipler* vz / 200f);
        long variabledfkdfop=(long) gold;

        goldThisTurn=0;


        float f=gold;
        //float f=3f;
        try {
            goldFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/goldValue.txt", false)));
            goldFileWriter.write(Float.toString(f));

            goldFileWriter.flush();
            goldFileWriter.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }



        save();



    }

    public static void load(){
        File file=new File(getmContext().getFilesDir()+"/goldValue.txt");

        Log.d("LOAD","GOLD and SCORE");

        try {
            goldFileReader  = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));
            Log.d("LOAD","GOLD and SCORE - 1");

            scoreFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/highScores.txt")));
////////////////////////scorerfileReaderCreated here
            Log.d("LOAD","GOLD and SCORE - 2");

            gold=0;
            Log.d("LOAD","GOLD and SCORE - 3");

            String go=goldFileReader.readLine();
            if(go==null){
                Log.d("LOAD","GOLD and SCORE - 3.null");

            }else{
                gold=Float.parseFloat(go);
            }

            Log.d("LOAD","GOLD and SCORE - 4");

            goldFileReader.close();
            Log.d("LOAD", "GOLD and SCORE - 5");

        }catch(IOException e){

            e.printStackTrace();

        }
        String l;
        int counterh=0;
        for(int c=0;c<highScores.length;c++){
            highScores[c]=0;
        }
        try {
            while((l=scoreFileReader.readLine())!=null){
                highScores[counterh]=Float.parseFloat(l);
                counterh++;
            }
            Log.d("LOAD","GOLD and SCORE - 6");

            Arrays.sort(highScores);
            Log.d("LOAD", "GOLD and SCORE - 7");

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            scoreFileReader.close();
            Log.d("LOAD", "GOLD and SCORE - 8");

        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        Log.d("LOAD","GOLD and SCORE - done");




        // File file1=new File("/storage/emulated/0/Android/data/gold.txt");



        //goldFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/"+"goldValue.txt")));


        // goldFileReader=new BufferedReader(new InputStreamReader(new FileInputStream("goldValue.txt")));
        //scoreFileReader=new BufferedReader(new InputStreamReader(new FileInputStream("highScores.txt")));
	    		/*
	    	     * Order of Variables in The Upgrade file.
	    	     *
	    	     * frequencyUpgradeNumber
	    	     * SpeedyUpgradeNumber
	    	     * InvincibilityUpgradeNumber
	    	     * MagnetUpgradeNumber
	    	     * ChestUpgradeNumber
	    	     * vehicles[0].getHandling()
	    	     * vehicles[0].getLuckPlus()
	    	     * vehicles[0].getSizePlus()
	    	     * vehicles[0].getArmourPlus()
	    	     * vehicles[1].getHandlingPlus()
	    	     * vehicles[1].getLuckPlus()
	    	     * vehicles[1].getSizePlus()
	    	     * vehicles[1].getArmourPlus()
	    	     * vehicles[2].getHandlingPlus()
	    	     * vehicles[2].getLuckPlus()
	    	     * vehicles[2].getSizePlus()
	    	     * vehicles[2].getArmourPlus()
	    	     *
	    	     *
	    	     */

        // } catch (FileNotFoundException e1) {
        //     // TODO Auto-generated catch block
        //    e1.printStackTrace();
        // }

        missionProgress[0]=0;
        missionProgress[1]=0;
        missionProgress[2]=0;
        missionProgress[3]=0;
        missionProgress[4]=0;


        /*int[] upgrades=
                {
                        frequencyUpgradeNumber,//0
                        SpeedyUpgradeNumber,//1
                        InvincibilityUpgradeNumber,//2
                        MagnetUpgradeNumber,//3
                        ChestUpgradeNumber,//4
                        (int)vehicles[0].getHandlingPlus(),//5
                        (int)vehicles[0].getLuckPlus(),//6
                        (int)(vehicles[0].getSizePlus()),//7
                        (int)vehicles[0].getArmourPlus(),//8
                        (int)vehicles[1].getHandlingPlus(),//9
                        (int)vehicles[1].getLuckPlus(),//10
                        (int)(vehicles[1].getSizePlus()),//11
                        (int)vehicles[1].getArmourPlus(),//12
                        (int)vehicles[2].getHandlingPlus(),//13
                        (int)vehicles[2].getLuckPlus(),//14
                        (int)(vehicles[2].getSizePlus()),//15
                        (int)vehicles[2].getArmourPlus(),//16
                        (int)vehicles[0].getBought(),//17
                        (int)(vehicles[1].getBought()),//18
                        (int)vehicles[2].getBought(),//19
                        missionProgress[0],//20
                        missionProgress[1],//21
                        missionProgress[2],//22
                        missionProgress[3],//23
                        missionProgress[4],//24
                        (int)selectedMission[0],//25
                        (int)selectedMission[1],//26
                        (int)selectedMission[2],//27
                        (int)vehicles[3].getHandlingPlus(),//28
                        (int)vehicles[3].getLuckPlus(),//29
                        (int)vehicles[3].getSizePlus(),//30
                        (int)vehicles[3].getArmourPlus(),//31
                        (int)vehicles[3].getBought(),//32
                        (int)vehicles[4].getHandlingPlus(),//33
                        (int)vehicles[4].getLuckPlus(),//34
                        (int)vehicles[4].getSizePlus(),//35
                        (int)vehicles[4].getArmourPlus(),//36
                        (int)vehicles[4].getBought(),//37
                        (int)vehicles[5].getHandlingPlus(),//
                        (int)vehicles[5].getLuckPlus(),//
                        (int)vehicles[5].getSizePlus(),//
                        (int)vehicles[5].getArmourPlus(),//
                        (int)vehicles[5].getBought(),//
                        (int)vehicles[6].getHandlingPlus(),//
                        (int)vehicles[6].getLuckPlus(),//
                        (int)vehicles[6].getSizePlus(),//
                        (int)vehicles[6].getArmourPlus(),//
                        (int)vehicles[6].getBought(),//
                        (int)vehicles[7].getHandlingPlus(),//
                        (int)vehicles[7].getLuckPlus(),//
                        (int)vehicles[7].getSizePlus(),//
                        (int)vehicles[7].getArmourPlus(),//
                        (int)vehicles[7].getBought(),//
                        (int)vehicles[8].getHandlingPlus(),//
                        (int)vehicles[8].getLuckPlus(),//
                        (int)vehicles[8].getSizePlus(),//
                        (int)vehicles[8].getArmourPlus(),//
                        (int)vehicles[8].getBought(),//
                        (int)vehicles[9].getHandlingPlus(),//
                        (int)vehicles[9].getLuckPlus(),//
                        (int)vehicles[9].getSizePlus(),//
                        (int)vehicles[9].getArmourPlus(),//
                        (int)vehicles[9].getBought(),//
                        (int)vehicles[10].getHandlingPlus(),//
                        (int)vehicles[10].getLuckPlus(),//
                        (int)vehicles[10].getSizePlus(),//
                        (int)vehicles[10].getArmourPlus(),//
                        (int)vehicles[10].getBought(),//
                        (int)vehicles[11].getHandlingPlus(),//
                        (int)vehicles[11].getLuckPlus(),//
                        (int)vehicles[11].getSizePlus(),//
                        (int)vehicles[11].getArmourPlus(),//
                        (int)vehicles[11].getBought(),//
                        gems
                        selected_vehicle
                        flying_saucer
                        theme_paperplane
                        no_ads
                };*/
        int[] upgrades=new int[80];

        for(int c=0;c<upgrades.length;c++){
            upgrades[c]=0;
        }


        String st;



        int counterUpgrades=0;
        try {
            upgradesFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/upgrades.txt")));

            try {
                while((st=upgradesFileReader.readLine())!=null){
                    //st=upgradesFileReader.readLine();
                    if(counterUpgrades<upgrades.length) {
                        upgrades[counterUpgrades] = Integer.parseInt(st);
                    }
                    counterUpgrades++;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                upgradesFileReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Log.d("LOAD","DONE loading upgrades");

        frequencyUpgradeNumber=(int) upgrades[0];
        SpeedyUpgradeNumber=(int) upgrades[1];
        InvincibilityUpgradeNumber=(int) upgrades[2];
        MagnetUpgradeNumber=(int) upgrades[3];
        ChestUpgradeNumber=(int) upgrades[4];
        vehicles[0].setHandlingPlus((float) upgrades[5]);
        vehicles[0].setLuckPlus((float) upgrades[6]);
        //vehicles[0].setSizePlus((float) ((float) upgrades[7] * 10f));
        vehicles[0].setSizePlus((float) upgrades[7]);

        vehicles[0].setArmourPlus((float) upgrades[8]);
        vehicles[1].setHandlingPlus((float) upgrades[9]);
        vehicles[1].setLuckPlus((float) upgrades[10]);
        //vehicles[1].setSizePlus((float) upgrades[11] * 10f);
        vehicles[1].setSizePlus((float) upgrades[11]);

        vehicles[1].setArmourPlus((float) upgrades[12]);
        vehicles[2].setHandlingPlus((float) upgrades[13]);
        vehicles[2].setLuckPlus((float) upgrades[14]);
        //vehicles[2].setSizePlus((float) upgrades[15] * 10f);
        vehicles[2].setSizePlus((float) upgrades[15]);

        vehicles[2].setArmourPlus((float) upgrades[16]);
        vehicles[0].setBought((int) upgrades[17]);
        vehicles[1].setBought((int) upgrades[18]);
        vehicles[2].setBought((int) upgrades[19]);

        missionProgress[0]=upgrades[20];
        missionProgress[1]=upgrades[21];
        missionProgress[2]=upgrades[22];
        missionProgress[3]=upgrades[23];
        missionProgress[4]=upgrades[24];
        selectedMission[0]=upgrades[25];
        selectedMission[1]=upgrades[26];
        selectedMission[2]=upgrades[27];

        vehicles[3].setHandlingPlus((float) upgrades[28]);
        vehicles[3].setLuckPlus((float) upgrades[29]);
        vehicles[3].setSizePlus((float) upgrades[30]);
        vehicles[3].setArmourPlus((float) upgrades[31]);
        vehicles[3].setBought((int) upgrades[32]);

        vehicles[4].setHandlingPlus((float) upgrades[33]);
        vehicles[4].setLuckPlus((float) upgrades[34]);
        vehicles[4].setSizePlus((float) upgrades[35]);
        vehicles[4].setArmourPlus((float) upgrades[36]);
        vehicles[4].setBought((int) upgrades[37]);

        vehicles[5].setHandlingPlus((float) upgrades[38]);
        vehicles[5].setLuckPlus((float) upgrades[39]);
        vehicles[5].setSizePlus((float) upgrades[40]);
        vehicles[5].setArmourPlus((float) upgrades[41]);
        vehicles[5].setBought((int) upgrades[42]);

        vehicles[6].setHandlingPlus((float) upgrades[43]);
        vehicles[6].setLuckPlus((float) upgrades[44]);
        vehicles[6].setSizePlus((float) upgrades[45]);
        vehicles[6].setArmourPlus((float) upgrades[46]);
        vehicles[6].setBought((int) upgrades[47]);

        vehicles[7].setHandlingPlus((float) upgrades[48]);
        vehicles[7].setLuckPlus((float) upgrades[49]);
        vehicles[7].setSizePlus((float) upgrades[50]);
        vehicles[7].setArmourPlus((float) upgrades[51]);
        vehicles[7].setBought((int) upgrades[52]);

        vehicles[8].setHandlingPlus((float) upgrades[53]);
        vehicles[8].setLuckPlus((float) upgrades[54]);
        vehicles[8].setSizePlus((float) upgrades[55]);
        vehicles[8].setArmourPlus((float) upgrades[56]);
        vehicles[8].setBought((int) upgrades[57]);

        vehicles[9].setHandlingPlus((float) upgrades[58]);
        vehicles[9].setLuckPlus((float) upgrades[59]);
        vehicles[9].setSizePlus((float) upgrades[60]);
        vehicles[9].setArmourPlus((float) upgrades[61]);
        vehicles[9].setBought((int) upgrades[62]);

        vehicles[10].setHandlingPlus((float) upgrades[63]);
        vehicles[10].setLuckPlus((float) upgrades[64]);
        vehicles[10].setSizePlus((float) upgrades[65]);
        vehicles[10].setArmourPlus((float) upgrades[66]);
        vehicles[10].setBought((int) upgrades[67]);

        vehicles[11].setHandlingPlus((float) upgrades[68]);
        vehicles[11].setLuckPlus((float) upgrades[69]);
        vehicles[11].setSizePlus((float) upgrades[70]);
        vehicles[11].setArmourPlus((float) upgrades[71]);
        vehicles[11].setBought((int)         upgrades[72]);

        gems=upgrades[73];
        selected_vehicle=upgrades[74];
        int v=75;

        if(upgrades.length>v){
            selected_theme=upgrades[v];

        }

        v++;
        if(upgrades.length>v){
            if(upgrades[v]==1){
                pptheme=true;
            }else{
                pptheme=false;

            }

        }
        v++;

        if(upgrades.length>v){
            if(upgrades[v]==1){
                flying_saucer=true;
            }else{
                flying_saucer=false;

            }

        }
        v++;

        if(upgrades.length>v){
            if(upgrades[v]==1){
                noads=true;
            }else{
                noads=false;

            }

        }
        v++;

        if(upgrades.length>v){
            gold=upgrades[v];

        }
        v++;


        Log.d("LOAD","DONE setting upgrades equal to things");


        //remember changes to on finish consumable and on finish purchases and load()

    }

    public static void saveRun(){//mContext.getFilesDir()+"/notfirsttime.txt"

        float f=gold;
        try {
            goldFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/goldValue.txt", false)));
            goldFileWriter.write(Float.toString(f));

            goldFileWriter.flush();

            goldFileWriter.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        Arrays.sort(highScores);
        if (score > highScores[0]) {
            highScores[0] = score;
            Arrays.sort(highScores);
        }

        try {
            BufferedWriter exist = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/notfirsttime.txt", false)));
            exist.write("This is not first time save has ran");

            exist.flush();

            exist.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            scoreFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/highScores.txt")));

            for (int c = 0; c < highScores.length; c++) {
                try {
                    scoreFileWriter.append(Float.toString(highScores[highScores.length - 1 - c]) + "\n");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            try {
                scoreFileWriter.flush();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Score Distance ExtraGold GOLDCOINS Multiplier TotalGold Earned

        try {
            lastRunFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/lastRun.txt")));


            try {
                //vz, gold, score, numberOfPowerUps


                //lastRunFileWriter.write((int) vz / 10 + "  \n" + (int) (goldThisTurn - vz / 100) + "  \n" + (int) score + "  \n" + (int) numberOfPowerUps + "  \n");
                lastRunFileWriter.write((int) score + "  \n" +(int) vz / 10 + "  \n" + (int) (goldThisTurn ) + "  \n" +  (int) numberOfPowerUps + "  \n");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                lastRunFileWriter.flush();
                lastRunFileWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }


    public static void load_lightweight(){
        File file=new File(getmContext().getFilesDir()+"/goldValue.txt");

        Log.d("LOAD","GOLD and SCORE");

        try {
            goldFileReader  = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));
            Log.d("LOAD","GOLD and SCORE - 1");

            scoreFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/highScores.txt")));
////////////////////////scorerfileReaderCreated here
            Log.d("LOAD","GOLD and SCORE - 2");

            gold=0;
            Log.d("LOAD","GOLD and SCORE - 3");

            String go=goldFileReader.readLine();
            if(go==null){
                Log.d("LOAD","GOLD and SCORE - 3.null");

            }else{
                gold=Float.parseFloat(go);
            }

            Log.d("LOAD","GOLD and SCORE - 4");

            goldFileReader.close();
            Log.d("LOAD", "GOLD and SCORE - 5");

        }catch(IOException e){

            e.printStackTrace();

        }
        String l;
        int counterh=0;
        for(int c=0;c<highScores.length;c++){
            highScores[c]=0;
        }
        try {
            while((l=scoreFileReader.readLine())!=null){
                highScores[counterh]=Float.parseFloat(l);
                counterh++;
            }
            Log.d("LOAD","GOLD and SCORE - 6");

            Arrays.sort(highScores);
            Log.d("LOAD", "GOLD and SCORE - 7");

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            scoreFileReader.close();
            Log.d("LOAD", "GOLD and SCORE - 8");

        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        Log.d("LOAD","GOLD and SCORE - done");




        // File file1=new File("/storage/emulated/0/Android/data/gold.txt");



        //goldFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/"+"goldValue.txt")));


        // goldFileReader=new BufferedReader(new InputStreamReader(new FileInputStream("goldValue.txt")));
        //scoreFileReader=new BufferedReader(new InputStreamReader(new FileInputStream("highScores.txt")));
	    		/*
	    	     * Order of Variables in The Upgrade file.
	    	     *
	    	     * frequencyUpgradeNumber
	    	     * SpeedyUpgradeNumber
	    	     * InvincibilityUpgradeNumber
	    	     * MagnetUpgradeNumber
	    	     * ChestUpgradeNumber
	    	     * vehicles[0].getHandling()
	    	     * vehicles[0].getLuckPlus()
	    	     * vehicles[0].getSizePlus()
	    	     * vehicles[0].getArmourPlus()
	    	     * vehicles[1].getHandlingPlus()
	    	     * vehicles[1].getLuckPlus()
	    	     * vehicles[1].getSizePlus()
	    	     * vehicles[1].getArmourPlus()
	    	     * vehicles[2].getHandlingPlus()
	    	     * vehicles[2].getLuckPlus()
	    	     * vehicles[2].getSizePlus()
	    	     * vehicles[2].getArmourPlus()
	    	     *
	    	     *
	    	     */

        // } catch (FileNotFoundException e1) {
        //     // TODO Auto-generated catch block
        //    e1.printStackTrace();
        // }

        missionProgress[0]=0;
        missionProgress[1]=0;
        missionProgress[2]=0;
        missionProgress[3]=0;
        missionProgress[4]=0;


        /*int[] upgrades=
                {
                        frequencyUpgradeNumber,//0
                        SpeedyUpgradeNumber,//1
                        InvincibilityUpgradeNumber,//2
                        MagnetUpgradeNumber,//3
                        ChestUpgradeNumber,//4
                        (int)vehicles[0].getHandlingPlus(),//5
                        (int)vehicles[0].getLuckPlus(),//6
                        (int)(vehicles[0].getSizePlus()),//7
                        (int)vehicles[0].getArmourPlus(),//8
                        (int)vehicles[1].getHandlingPlus(),//9
                        (int)vehicles[1].getLuckPlus(),//10
                        (int)(vehicles[1].getSizePlus()),//11
                        (int)vehicles[1].getArmourPlus(),//12
                        (int)vehicles[2].getHandlingPlus(),//13
                        (int)vehicles[2].getLuckPlus(),//14
                        (int)(vehicles[2].getSizePlus()),//15
                        (int)vehicles[2].getArmourPlus(),//16
                        (int)vehicles[0].getBought(),//17
                        (int)(vehicles[1].getBought()),//18
                        (int)vehicles[2].getBought(),//19
                        missionProgress[0],//20
                        missionProgress[1],//21
                        missionProgress[2],//22
                        missionProgress[3],//23
                        missionProgress[4],//24
                        (int)selectedMission[0],//25
                        (int)selectedMission[1],//26
                        (int)selectedMission[2],//27
                        (int)vehicles[3].getHandlingPlus(),//28
                        (int)vehicles[3].getLuckPlus(),//29
                        (int)vehicles[3].getSizePlus(),//30
                        (int)vehicles[3].getArmourPlus(),//31
                        (int)vehicles[3].getBought(),//32
                        (int)vehicles[4].getHandlingPlus(),//33
                        (int)vehicles[4].getLuckPlus(),//34
                        (int)vehicles[4].getSizePlus(),//35
                        (int)vehicles[4].getArmourPlus(),//36
                        (int)vehicles[4].getBought(),//37
                        (int)vehicles[5].getHandlingPlus(),//
                        (int)vehicles[5].getLuckPlus(),//
                        (int)vehicles[5].getSizePlus(),//
                        (int)vehicles[5].getArmourPlus(),//
                        (int)vehicles[5].getBought(),//
                        (int)vehicles[6].getHandlingPlus(),//
                        (int)vehicles[6].getLuckPlus(),//
                        (int)vehicles[6].getSizePlus(),//
                        (int)vehicles[6].getArmourPlus(),//
                        (int)vehicles[6].getBought(),//
                        (int)vehicles[7].getHandlingPlus(),//
                        (int)vehicles[7].getLuckPlus(),//
                        (int)vehicles[7].getSizePlus(),//
                        (int)vehicles[7].getArmourPlus(),//
                        (int)vehicles[7].getBought(),//
                        (int)vehicles[8].getHandlingPlus(),//
                        (int)vehicles[8].getLuckPlus(),//
                        (int)vehicles[8].getSizePlus(),//
                        (int)vehicles[8].getArmourPlus(),//
                        (int)vehicles[8].getBought(),//
                        (int)vehicles[9].getHandlingPlus(),//
                        (int)vehicles[9].getLuckPlus(),//
                        (int)vehicles[9].getSizePlus(),//
                        (int)vehicles[9].getArmourPlus(),//
                        (int)vehicles[9].getBought(),//
                        (int)vehicles[10].getHandlingPlus(),//
                        (int)vehicles[10].getLuckPlus(),//
                        (int)vehicles[10].getSizePlus(),//
                        (int)vehicles[10].getArmourPlus(),//
                        (int)vehicles[10].getBought(),//
                        (int)vehicles[11].getHandlingPlus(),//
                        (int)vehicles[11].getLuckPlus(),//
                        (int)vehicles[11].getSizePlus(),//
                        (int)vehicles[11].getArmourPlus(),//
                        (int)vehicles[11].getBought(),//
                        gems
                        selected_vehicle
                        flying_saucer
                        theme_paperplane
                        no_ads
                };*/
        int[] upgrades=new int[80];

        for(int c=0;c<upgrades.length;c++){
            upgrades[c]=0;
        }


        String st;



        int counterUpgrades=0;
        try {
            upgradesFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/upgrades.txt")));

            try {
                while((st=upgradesFileReader.readLine())!=null){
                    //st=upgradesFileReader.readLine();
                    if(counterUpgrades<upgrades.length) {
                        upgrades[counterUpgrades] = Integer.parseInt(st);
                    }
                    counterUpgrades++;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                upgradesFileReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Log.d("LOAD","DONE loading upgrades");


        if(upgrades[upgrades.length-2]==1){
            noads=true;
        }else{
            noads=false;

        }






        Log.d("LOAD","DONE setting upgrades equal to things");


        //remember changes to on finish consumable and on finish purchases and load()

    }
















    public static void save(){
        float f=gold;
        try {
            goldFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/goldValue.txt", false)));
            goldFileWriter.write(Float.toString(f));
            goldFileWriter.flush();

            goldFileWriter.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        int[] upgradesBooleans=new int[3];
        if(flying_saucer){
            upgradesBooleans[0]=1;}else{
            upgradesBooleans[0]=0;}

        if(pptheme){
            upgradesBooleans[1]=1;}else{
            upgradesBooleans[1]=0;}

        if(noads){
            upgradesBooleans[2]=1;}else{
            upgradesBooleans[2]=0;}

        Log.d("SAVING","Starting save");
        int[] upgrades=
                {
                        frequencyUpgradeNumber,//0
                        SpeedyUpgradeNumber,//1
                        InvincibilityUpgradeNumber,//2
                        MagnetUpgradeNumber,//3
                        ChestUpgradeNumber,//4
                        (int)vehicles[0].getHandlingPlus(),//5
                        (int)vehicles[0].getLuckPlus(),//6
                        (int)(vehicles[0].getSizePlus()),//7
                        (int)vehicles[0].getArmourPlus(),//8
                        (int)vehicles[1].getHandlingPlus(),//9
                        (int)vehicles[1].getLuckPlus(),//10
                        (int)(vehicles[1].getSizePlus()),//11
                        (int)vehicles[1].getArmourPlus(),//12
                        (int)vehicles[2].getHandlingPlus(),//13
                        (int)vehicles[2].getLuckPlus(),//14
                        (int)(vehicles[2].getSizePlus()),//15
                        (int)vehicles[2].getArmourPlus(),//16
                        (int)vehicles[0].getBought(),//17
                        (int)(vehicles[1].getBought()),//18
                        (int)vehicles[2].getBought(),//19
                        missionProgress[0],//20
                        missionProgress[1],//21
                        missionProgress[2],//22
                        missionProgress[3],//23
                        missionProgress[4],//24
                        (int)selectedMission[0],//25
                        (int)selectedMission[1],//26
                        (int)selectedMission[2],//27
                        (int)vehicles[3].getHandlingPlus(),//28
                        (int)vehicles[3].getLuckPlus(),//29
                        (int)vehicles[3].getSizePlus(),//30
                        (int)vehicles[3].getArmourPlus(),//31
                        (int)vehicles[3].getBought(),//32
                        (int)vehicles[4].getHandlingPlus(),//33
                        (int)vehicles[4].getLuckPlus(),//34
                        (int)vehicles[4].getSizePlus(),//35
                        (int)vehicles[4].getArmourPlus(),//36
                        (int)vehicles[4].getBought(),//37
                        (int)vehicles[5].getHandlingPlus(),//38
                        (int)vehicles[5].getLuckPlus(),//39
                        (int)vehicles[5].getSizePlus(),//40
                        (int)vehicles[5].getArmourPlus(),//41
                        (int)vehicles[5].getBought(),//42
                        (int)vehicles[6].getHandlingPlus(),//43
                        (int)vehicles[6].getLuckPlus(),//44
                        (int)vehicles[6].getSizePlus(),//45
                        (int)vehicles[6].getArmourPlus(),//46
                        (int)vehicles[6].getBought(),//47
                        (int)vehicles[7].getHandlingPlus(),//48
                        (int)vehicles[7].getLuckPlus(),//49
                        (int)vehicles[7].getSizePlus(),//50
                        (int)vehicles[7].getArmourPlus(),//51
                        (int)vehicles[7].getBought(),//52
                        (int)vehicles[8].getHandlingPlus(),//53
                        (int)vehicles[8].getLuckPlus(),//54
                        (int)vehicles[8].getSizePlus(),//55
                        (int)vehicles[8].getArmourPlus(),//56
                        (int)vehicles[8].getBought(),//57
                        (int)vehicles[9].getHandlingPlus(),//58
                        (int)vehicles[9].getLuckPlus(),//59
                        (int)vehicles[9].getSizePlus(),//60
                        (int)vehicles[9].getArmourPlus(),//61
                        (int)vehicles[9].getBought(),//62
                        (int)vehicles[10].getHandlingPlus(),//63
                        (int)vehicles[10].getLuckPlus(),//64
                        (int)vehicles[10].getSizePlus(),//65
                        (int)vehicles[10].getArmourPlus(),//66
                        (int)vehicles[10].getBought(),//67
                        (int)vehicles[11].getHandlingPlus(),//68
                        (int)vehicles[11].getLuckPlus(),//69
                        (int)vehicles[11].getSizePlus(),//70
                        (int)vehicles[11].getArmourPlus(),//71
                        (int)vehicles[11].getBought(),//72
                        (int)gems,//73
                        selected_vehicle,//74
                        selected_theme,//75
                        upgradesBooleans[0],//76
                        upgradesBooleans[1], //77
                        upgradesBooleans[2],//78
                        (int)gold//79
                };

        Log.d("SAVING","Ended save");



        try {
            upgradesFileWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/upgrades.txt")));

            for (int c=0;c<upgrades.length;c++){
                try {
                    upgradesFileWriter.write(Integer.toString(upgrades[c]));
                    upgradesFileWriter.newLine();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }


        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            upgradesFileWriter.flush();
            upgradesFileWriter.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

    }
    public float calculateTimeMod(){
        float sum=0;
        for(int c=0;c<fpses.length;c++){
            sum=sum+fpses[c];
        }
        float averagefps=(float)sum/(float)fpses.length;
        //if(fps!=0){return 25f/(float)(fps);}else{return 1f;}

        if(averagefps>25){
            float r=25f/(float)
                    (averagefps);
            if(r>0.02f&&r<100f){
                return r;
            }else{
                return 1f;
            }
        }else{

            return 1f;
        }
    }


    public void startTimer(){
        waitLater=true;


        sec=System.nanoTime();


    }
    public void endTimer(){
        if(Math.abs(System.nanoTime()-sec)>800000000l||System.nanoTime()-sec<0){
            waitLater=false;
        }
    }


    public float getM1() {
        return m1;
    }

    public void setM1(float m1) {
        this.m1 = m1;
    }

    public float getM2() {
        return m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    public float getM3() {
        return m3;
    }

    public void setM3(float m3) {
        this.m3 = m3;
    }

    public float getM4() {
        return m4;
    }

    public void setM4(float m4) {
        this.m4 = m4;
    }
}



/*

things to do in SwE

in draw arrays remove/2

spare comma in gold2 color
            in gold3 indices


add in glblend

just copy the whole of the

27/08/15

copy and past all vehicle classes
 */

//I have added firebase and android to com.google.

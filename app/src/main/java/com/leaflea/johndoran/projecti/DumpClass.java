package com.leaflea.johndoran.projecti;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;



/*

weird error : if dont delare
 */
public class DumpClass implements GLSurfaceView.Renderer {

    private static Context mContext;
    private static FloatBuffer mVertexBuffer = null;
    private static ShortBuffer mTriangleBorderIndicesBuffer = null;
    private static int mNumOfTriangleBorderIndices = 0;


    //public static int frequencyUpgradeNumber=0;//////////////////////////
    //public static int SpeedyUpgradeNumber=0;//////////////////////////
    //public static int InvincibilityUpgradeNumber=0;//////////////////////////
    //public static int MagnetUpgradeNumber=0;//////////////////////////
    //public static int ChestUpgradeNumber=0;//////////////////////////



    //public static float getXaxis() {
    //   return xaxis;
    //}
    // public static void setXaxis(float xaxis) {
    //     Main.xaxis = xaxis;
    // }
    //public static float getYaxis() {
    //   return yaxis;
    //}
    //public static void setYaxis(float yaxis) {
    //    Main.yaxis = yaxis;
    //}
    /*public static int getScreen_Width() {
        return Screen_Width;
    }
    public static void setScreen_Width(int screen_Width) {
        Screen_Width = screen_Width;
    }
    public static int getScreen_Height() {
        return Screen_Height;
    }
    public static void setScreen_Height(int screen_Height) {
        Screen_Height = screen_Height;
    }*/
    public static float getGold() {
        return gold;
    }
    /*
    public static int getExtraFrequencyNumber() {
        return frequencyUpgradeNumber;
    }
    //public static void setExtraFrequencyNumber(int extraFrequencyNumber) {
    //    Main.frequencyUpgradeNumber = extraFrequencyNumber;
    //}
    public static int getChestUpgradeNumber() {
        return ChestUpgradeNumber;
    }
    public static void setChestUpgradeNumber(int chestUpgradeNumber) {
        ChestUpgradeNumber = chestUpgradeNumber;
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
    }*/


    public static int coinsFromChest=50;
    public static int framesUntilNormalSpeedy=100;
    public static int framesUntilNormalInvincibility=150;
    public static int framesUntilNormalMagnet=150;

    public static int frequencyUpgradeNumber=0;
    public static int SpeedyUpgradeNumber=0;
    public static int InvincibilityUpgradeNumber=0;
    public static int MagnetUpgradeNumber=0;
    public static int ChestUpgradeNumber=0;

    public static int distanceDecreasedPerExtraFrequencyNumber=25;
    public static int extraCoinsFromChestUpgradeNumber=25;
    public static int extraFramesUntilNormalSpeedyUpgradeNumber=40;
    public static int extraFramesUntilNormalInvincibilityUpgradeNumber=50;
    public static int extraFramesUntilNormalMagnetUpgradeNumber=50;
    public Boolean pauseMenuActivated;
    public static int mx;
    public static int my;

    //public static Boolean mouseDown;

    public static int wah;



    public static float cameraheight=6f;
    public static float cameradiatancebehind=20f;


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

    public static float default_x_vrotspeed=0.015f;
    public static float default_y_vrotspeed=0.015f;
    public static float vrotspeed=0.1f;




    public static The_Cube TC;
    public static float default_TCSpeed=0.16f;

    public static float TCSpeed=0.16f;
    public static float xTCSpeed=0.16f;
    public static float yTCSpeed=0.16f;
    public static long fps=0;
    public static float rotlimit=20;

    public static float h=2f;
    public static float CameraX=0;
    public static float CameraY=0;
    public static float CameraZ=-10;
    public static float CameraRX=180;

    public static float CameraMovement=01f;

    public static int presentstage=0;


/*
    public static Gold[] gold_object=new Gold[350];
    public static float[] goldx=new float[gold_object.length];
    public static float[] goldy=new float[gold_object.length];
    public static float[] goldz=new float[gold_object.length];

    public static float[] goldvx=new float[gold_object.length];
    public static float[] goldvy=new float[gold_object.length];
    public static float[] goldvz=new float[gold_object.length];

    public static int[] goldValue=new int[gold_object.length];
    public static Boolean[] goldWantSpawned=new Boolean[gold_object.length];



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

*/

    public static Menus menus;
    public static float zmov=0f;



    public static float rocketspawnlength=4000f;
    public static float BODspawnlength=2000f;
    public static float goldSpawnLength=100f;
    public static int rotation;
    public static Boolean skipped=true;
    public static int spawnnum;



    public static int counterPopUp=0;
    //public static int r=0;
    public static float collisionx=0;
    public static float collisiony=0;
    public static float amountabovecam=5f;
    public static Collisions co;






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

    public static float gold=1000000;
    public static float goldThisTurn=0;
    public static int resetLives=1;
    public static int lives=resetLives;
    public static int startlives;
    public static int endlives;
    public static Boolean alreadyCollided=false;

    public static Boolean powerUpSpeedOn=false;
    public static Boolean collisionsOn=true;
    public static String playername="Desmond";
    public static float velocityz=2f;
    public static float accelerationz=0.01f;
    public static float vx=0;
    public static float vy=0;
    public static float vz=0;
    public static float xrot=0;
    public static float yrot=0;
    public static float zrot=0;
    public static int option=1;
    public static int menuoption=0;
    //public static TrueTypeFont font;
    //public static TrueTypeFont font2;



    public static Boolean que=true;
    public static Boolean que1=true;
    public static Boolean[] respawneverything=new Boolean[20];
    public static Vehicles[] vehicles;///////////////////////Need to put into other class

    //public static Texture menu;

    /*
        public static int goldSpawnNum=0;
        public static float lastGoldSpawnPoint=-100f;
        public static int framesUntilNormal=400;
        public static int framesUntilNormal2=400;





        public static int maxUpgradeNumber=5;


        public static int framesUntilCollisionsNormalPlus=0;


        public static float PLATINUMCheackpointOne=1000f;
        public static float PLATINUMCheackpointTwo=3000f;
        public static float PLATINUMAbundance=0.2f;

        public static float DIAMONDCheackpointOne=3000f;
        public static float DIAMONDCheackpointTwo=3000f;
        public static float DIAMONDAbundance=0.1f;

        public static float CheckpointPLATINUMbonus1=0.1f;
        public static float CheckpointDIAMONDbonus1=0.00f;
        public static float CheckpointPLATINUMbonus2=0.2f;
        public static float CheckpointDIAMONDbonus2=0.1f;

        public static float Checkpoint1=2000f;
        public static float Checkpoint2=4000f;



        public static float px=0;
        public static float py=1000000f;
        public static float pz=0f;
        public static float powerUpFrequency=5000f;
        public static int powerupNumber=1;
        public static Boolean effectCanCancel=true;


        // public static int Screen_Width  = android.view.Display.getWidth()  ;
        //public static int Screen_Height = android.view.Display.getHeight() ;
       // public static int Screen_Width =400 ;
       // public static int Screen_Height=300 ;

        public static Boolean MENU_CLICK_ACTIVATED=true;



        public static int numberOfPowerUps=0;
        public static int noc=15;
        public static float[] RX  =new float[noc];
        public static float[] RY  =new float[noc];
        public static float[] RZ  =new float[noc];
        public static Rock[] rock =new Rock [noc];
        private static FileWriter writer ;
        private static Scanner scan;

        //  private static File scores;
        private static String temp;


        public static float BODspawnnum=0f;
        public static float rocketspawnnum=0f;
        public static float magcounterx=0f;
        public static float magcountery=0f;

        public static float vzBeforeFirstGold=0;
        public static float vzBeforeFirstPowerUp=0;



        public static int counter4=0;

        public static int[] missionProgress=new int[5];

        public static String[] missionTitles={"RUNNER","GAMER","MISER","HERO","SPARTAN","ERROR","ERROR"};
        public static String[] missionDescriptions={"RUN ","GET SCORE OF ","EARN, IN ONE TURN ","GET ","WITHOUT POWERUPS, RUN ","ERROR","ERROR"};
        public static String[] missionUpgradeTitles={"BEGINNER","FOOL","NOVICE","AMATEUR","INTERMEDIATE","BEAST","PRO","WORLDLY","OTHER-WORLDLY","LEGENDARY","EH...COOL?","NUMBER 1","*ADJECTIVE*","*SUPERLATIVE*","ERROR","#HASHTAG"};

        public static int[] selectedMission=new int[3];
        public static int[] completedMission=new int[3];
    */
    public static BufferedWriter goldFileWriter;
    public static BufferedReader goldFileReader;
    /* public static BufferedReader upgradesFileReader;
     public static BufferedWriter upgradesFileWriter;
     public static BufferedReader lastRunFileReader;
     public static BufferedWriter lastRunFileWriter;

     public static BufferedWriter scoreFileWriter;
     public static BufferedReader scoreFileReader;

     public static float[] highScores=new float[10];

     public static Boolean full_screen=true;*/
    renderController rC=new renderController();
    FontClass FONT;



    public float mAngleX = 0.0f;
    public float mAngleY = 0.0f;
    public float mAngleZ = 0.0f;

    private float mPreviousX;
    private float mPreviousY;

    private final float TOUCH_SCALE_FACTOR = 0.3f;

    public static float Screen_Height;
    public static float Screen_Width;
    public static GL10 gl;


    //public Vehicles[] vehicles;/////////////
    //public int selected_vehicle=0;

    //public BallOfDeath BOD;/////////////////
    //public Rocket rocket;///////////////////



    //private static int[] mTextureList = null;

    public Boolean mouseDown=false;
    public Boolean mouseDownLast=false;
    public DumpClass(Context context) {
        setmContext(context);
    }
    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        DumpClass.mContext = mContext;
    }

    public static FloatBuffer getmVertexBuffer() {
        return mVertexBuffer;
    }

    public static void setmVertexBuffer(FloatBuffer mVertexBuffer) {
        DumpClass.mVertexBuffer = mVertexBuffer;
    }

    public static ShortBuffer getmTriangleBorderIndicesBuffer() {
        return mTriangleBorderIndicesBuffer;
    }

    public static void setmTriangleBorderIndicesBuffer(ShortBuffer mTriangleBorderIndicesBuffer) {
        DumpClass.mTriangleBorderIndicesBuffer = mTriangleBorderIndicesBuffer;
    }

    public static int getmNumOfTriangleBorderIndices() {
        return mNumOfTriangleBorderIndices;
    }

    public static void setmNumOfTriangleBorderIndices(int mNumOfTriangleBorderIndices) {
        DumpClass.mNumOfTriangleBorderIndices = mNumOfTriangleBorderIndices;
    }

    public static int[] getmTextureList() {
        return mTextureList;
    }

    public static void setmTextureList(int[] mTextureList) {
        DumpClass.mTextureList = mTextureList;
    }


    //public static BufferedReader goldFileReader;
    //public static BufferedReader scoreFileReader;
    private static int[] mTextureList=null;



    public static Bitmap b;

    public static Bitmap getB() {
        return b;
    }

    public static void setB(Bitmap b) {
        DumpClass.b = b;
    }

    // public static BufferedWriter goldFileWriter;
    //  public static BufferedReader goldFileReader;
    String mainString;
    File file;

    public static FloatBuffer getmTriangleColorBuffer() {
        return mTriangleColorBuffer;
    }

    public static void setmTriangleColorBuffer(FloatBuffer mTriangleColorBuffer) {
        DumpClass.mTriangleColorBuffer = mTriangleColorBuffer;
    }

    public static FloatBuffer getmTriangleUVBuffer() {
        return mTriangleUVBuffer;
    }

    public static void setmTriangleUVBuffer(FloatBuffer mTriangleUVBuffer) {
        DumpClass.mTriangleUVBuffer = mTriangleUVBuffer;
    }

    public static FloatBuffer getmStandardRectVerts() {
        return mStandardRectVerts;
    }

    public static void setmStandardRectVerts(FloatBuffer mStandardRectVerts) {
        DumpClass.mStandardRectVerts = mStandardRectVerts;
    }

    public static FloatBuffer getmWallRectVerts() {
        return mWallRectVerts;
    }

    public static void setmWallRectVerts(FloatBuffer mWallRectVerts) {
        DumpClass.mWallRectVerts = mWallRectVerts;
    }

    public static FloatBuffer getmWallStripRectVerts() {
        return mWallStripRectVerts;
    }

    public static void setmWallStripRectVerts(FloatBuffer mWallStripRectVerts) {
        DumpClass.mWallStripRectVerts = mWallStripRectVerts;
    }

    public static FloatBuffer getmStandardCuboidVerts() {
        return mStandardCuboidVerts;
    }

    public static void setmStandardCuboidVerts(FloatBuffer mStandardCuboidVerts) {
        DumpClass.mStandardCuboidVerts = mStandardCuboidVerts;
    }

    public static FloatBuffer getmVehicleVerts() {
        return mVehicleVerts;
    }

    public static void setmVehicleVerts(FloatBuffer mVehicleVerts) {
        DumpClass.mVehicleVerts = mVehicleVerts;
    }

    public static FloatBuffer getmRocketVerts() {
        return mRocketVerts;
    }

    public static void setmRocketVerts(FloatBuffer mRocketVerts) {
        DumpClass.mRocketVerts = mRocketVerts;
    }

    public static FloatBuffer getmBODVerts() {
        return mBODVerts;
    }

    public static void setmBODVerts(FloatBuffer mBODVerts) {
        DumpClass.mBODVerts = mBODVerts;
    }

    public static FloatBuffer getmGold1Verts() {
        return mGold1Verts;
    }

    public static void setmGold1Verts(FloatBuffer mGold1Verts) {
        DumpClass.mGold1Verts = mGold1Verts;
    }

    public static FloatBuffer getmGold2Verts() {
        return mGold2Verts;
    }

    public static void setmGold2Verts(FloatBuffer mGold2Verts) {
        DumpClass.mGold2Verts = mGold2Verts;
    }

    public static FloatBuffer getmGold3Verts() {
        return mGold3Verts;
    }

    public static void setmGold3Verts(FloatBuffer mGold3Verts) {
        DumpClass.mGold3Verts = mGold3Verts;
    }

    public static FloatBuffer getmGUItopper() {
        return mGUItopper;
    }

    public static void setmGUItopper(FloatBuffer mGUItopper) {
        DumpClass.mGUItopper = mGUItopper;
    }

    public static FloatBuffer getmGUIBigCircleVerts() {
        return mGUIBigCircleVerts;
    }

    public static void setmGUIBigCircleVerts(FloatBuffer mGUIBigCircleVerts) {
        DumpClass.mGUIBigCircleVerts = mGUIBigCircleVerts;
    }

    public static FloatBuffer getmGUILittleCircleVerts() {
        return mGUILittleCircleVerts;
    }

    public static void setmGUILittleCircleVerts(FloatBuffer mGUILittleCircleVerts) {
        DumpClass.mGUILittleCircleVerts = mGUILittleCircleVerts;
    }

    public static FloatBuffer getmTagVerts() {
        return mTagVerts;
    }

    public static void setmTagVerts(FloatBuffer mTagVerts) {
        DumpClass.mTagVerts = mTagVerts;
    }

    public static FloatBuffer getmSmallRectVerts() {
        return mSmallRectVerts;
    }

    public static void setmSmallRectVerts(FloatBuffer mSmallRectVerts) {
        DumpClass.mSmallRectVerts = mSmallRectVerts;
    }

    public static FloatBuffer getmMidRectVerts() {
        return mMidRectVerts;
    }

    public static void setmMidRectVerts(FloatBuffer mMidRectVerts) {
        DumpClass.mMidRectVerts = mMidRectVerts;
    }

    public static FloatBuffer getmCeilingVerts() {
        return mCeilingVerts;
    }

    public static void setmCeilingVerts(FloatBuffer mCeilingVerts) {
        DumpClass.mCeilingVerts = mCeilingVerts;
    }

    public static FloatBuffer getmStandardCuboidColor() {
        return mStandardCuboidColor;
    }

    public static void setmStandardCuboidColor(FloatBuffer mStandardCuboidColor) {
        DumpClass.mStandardCuboidColor = mStandardCuboidColor;
    }

    public static FloatBuffer getmVehicleColor() {
        return mVehicleColor;
    }

    public static void setmVehicleColor(FloatBuffer mVehicleColor) {
        DumpClass.mVehicleColor = mVehicleColor;
    }

    public static FloatBuffer getmRocketsColor() {
        return mRocketsColor;
    }

    public static void setmRocketsColor(FloatBuffer mRocketsColor) {
        DumpClass.mRocketsColor = mRocketsColor;
    }

    public static FloatBuffer getmGold1Color() {
        return mGold1Color;
    }

    public static void setmGold1Color(FloatBuffer mGold1Color) {
        DumpClass.mGold1Color = mGold1Color;
    }

    public static FloatBuffer getmGold2Color() {
        return mGold2Color;
    }

    public static void setmGold2Color(FloatBuffer mGold2Color) {
        DumpClass.mGold2Color = mGold2Color;
    }

    public static FloatBuffer getmGold3Color() {
        return mGold3Color;
    }

    public static void setmGold3Color(FloatBuffer mGold3Color) {
        DumpClass.mGold3Color = mGold3Color;
    }

    public static FloatBuffer getmStandardRectUVCoordsVerts() {
        return mStandardRectUVCoordsVerts;
    }

    public static void setmStandardRectUVCoordsVerts(FloatBuffer mStandardRectUVCoordsVerts) {
        DumpClass.mStandardRectUVCoordsVerts = mStandardRectUVCoordsVerts;
    }

    public static FloatBuffer getmUVCoordsStandardCuboid() {
        return mUVCoordsStandardCuboid;
    }

    public static void setmUVCoordsStandardCuboid(FloatBuffer mUVCoordsStandardCuboid) {
        DumpClass.mUVCoordsStandardCuboid = mUVCoordsStandardCuboid;
    }

    public static ShortBuffer getmStandardRectInd() {
        return mStandardRectInd;
    }

    public static void setmStandardRectInd(ShortBuffer mStandardRectInd) {
        DumpClass.mStandardRectInd = mStandardRectInd;
    }

    public static ShortBuffer getmStandardCuboidInd() {
        return mStandardCuboidInd;
    }

    public static void setmStandardCuboidInd(ShortBuffer mStandardCuboidInd) {
        DumpClass.mStandardCuboidInd = mStandardCuboidInd;
    }

    public static ShortBuffer getmVehicleInd() {
        return mVehicleInd;
    }

    public static void setmVehicleInd(ShortBuffer mVehicleInd) {
        DumpClass.mVehicleInd = mVehicleInd;
    }

    public static ShortBuffer getmRocketInd() {
        return mRocketInd;
    }

    public static void setmRocketInd(ShortBuffer mRocketInd) {
        DumpClass.mRocketInd = mRocketInd;
    }

    public static ShortBuffer getmBODInd() {
        return mBODInd;
    }

    public static void setmBODInd(ShortBuffer mBODInd) {
        DumpClass.mBODInd = mBODInd;
    }

    public static ShortBuffer getmGold1Ind() {
        return mGold1Ind;
    }

    public static void setmGold1Ind(ShortBuffer mGold1Ind) {
        DumpClass.mGold1Ind = mGold1Ind;
    }

    public static ShortBuffer getmGold2Ind() {
        return mGold2Ind;
    }

    public static void setmGold2Ind(ShortBuffer mGold2Ind) {
        DumpClass.mGold2Ind = mGold2Ind;
    }

    public static ShortBuffer getmGold3Ind() {
        return mGold3Ind;
    }

    public static void setmGold3Ind(ShortBuffer mGold3Ind) {
        DumpClass.mGold3Ind = mGold3Ind;
    }

    public static ShortBuffer getmGUICircleInd() {
        return mGUICircleInd;
    }

    public static void setmGUICircleInd(ShortBuffer mGUICircleInd) {
        DumpClass.mGUICircleInd = mGUICircleInd;
    }

    public static FloatBuffer getmVehicleSecondaryVerts() {
        return mVehicleSecondaryVerts;
    }

    public static void setmVehicleSecondaryVerts(FloatBuffer mVehicleSecondaryVerts) {
        DumpClass.mVehicleSecondaryVerts = mVehicleSecondaryVerts;
    }

    public static FloatBuffer getmVehicleSecondaryColor() {
        return mVehicleSecondaryColor;
    }

    public static void setmVehicleSecondaryColor(FloatBuffer mVehicleSecondaryColor) {
        DumpClass.mVehicleSecondaryColor = mVehicleSecondaryColor;
    }

    public static ShortBuffer getmVehicleSecondaryInd() {
        return mVehicleSecondaryInd;
    }

    public static void setmVehicleSecondaryInd(ShortBuffer mVehicleSecondaryInd) {
        DumpClass.mVehicleSecondaryInd = mVehicleSecondaryInd;
    }
    public float r[];

    public static FloatBuffer getmBODColor() {
        return mBODColor;
    }

    public static void setmBODColor(FloatBuffer mBODColor) {
        DumpClass.mBODColor = mBODColor;
    }

    public static int getFrequencyUpgradeNumber() {
        return frequencyUpgradeNumber;
    }

    public static void setFrequencyUpgradeNumber(int frequencyUpgradeNumber) {
        DumpClass.frequencyUpgradeNumber = frequencyUpgradeNumber;
    }

    public static int getExtraFrequencyNumber() {
        return frequencyUpgradeNumber;
    }

    public static void setExtraFrequencyNumber(int frequencyUpgradeNumber) {
        DumpClass.frequencyUpgradeNumber = frequencyUpgradeNumber;
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

    public static CentralisedVariables CV;
    //private Enemies[] sj=new The_Cube[10];
    //private Enemies[] sj;

    public static int selected_vehicle=2;


    Wall_plain w1;
    Wall_plain w2;
    //Wall_plain w3;
//Wall_plain w4;
//Wall_plain w5;
//Wall_plain w6;
    Ceiling_plain c1;
    Ceiling_plain c2;
    Ceiling_plain c3;


    //Rock rock;
    PowerUps power;
    //CentralisedVariables CV ;
    //Menus menus;



    // Boolean mouseDownLast=false;
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {


        vehicles=new Vehicles[3];

        vehicles[0]=new The_Cube(gl,0,0,0,0,0,0);
        vehicles[1]=new Motor(gl,0,0,0,0,0,0);
        vehicles[2]=new ElectricRing(gl,0,0,0,0,0,0);

        //BOD[0]=new BallOfDeath(gl,0,0,0);
        //rocket[0]=new Rocket(gl,0,0,0);

        w1 = new Wall_plain(gl,0, false);
        w2 = new Wall_plain(gl,0, true);
        //Wall_plain w3 = new Wall_plain(gl,z2, false);
        //Wall_plain w4 = new Wall_plain(gl,z2, true);
        //Wall_plain w5 = new Wall_plain(gl,z3, false);
        //Wall_plain w6 = new Wall_plain(gl,z3, true);

        c1 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, 0, false);
        //Ceiling_plain c2 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z2, false);
        //Ceiling_plain c3 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z3, false);


        co=new Collisions();


        //rock[0]=new Rock(gl,0,0,0);
        //power=new PowerUps(gl,0f,0f,0f,4);

        menus=new Menus(gl);

        rC.giveContext(mContext);
        CV =new CentralisedVariables();

        setUpBuffers();
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);	         //  kinda  irrelevant
        mTextureList=new int[1];

        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl.glGenTextures(1, mTextureList, 0);
        gl.glClientActiveTexture(GL10.GL_TEXTURE0);


        Bitmap b = BitmapFactory.decodeResource(getmContext().getResources(), R.drawable.lock);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, b, 0);

        Bitmap d = BitmapFactory.decodeResource(getmContext().getResources(), R.drawable.tick);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, b, 0);




        //completedMission[0]=99;
        //completedMission[1]=99;
        //completedMission[2]=99;

        //b.recycle();

        // try {

        //goldFileWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("goldValue.txt",false)));


        File file=new File(getmContext().getFilesDir()+"/goldValue.txt");

        try {
            goldFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath(), false)));
            goldFileWriter.write("CHECK");
            goldFileWriter.flush();
            goldFileWriter.close();
        }
        catch(IOException e){
            //TODO
            e.printStackTrace();
        }



        try {
            goldFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));
            mainString=goldFileReader.readLine();
            goldFileReader.close();
        }catch(IOException e){

            e.printStackTrace();

        }
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



/*
        missionProgress[0]=0;
        missionProgress[1]=0;
        missionProgress[2]=0;
        missionProgress[3]=0;
        missionProgress[4]=0;


        int[] upgrades=
                {
                        frequencyUpgradeNumber,
                        SpeedyUpgradeNumber,
                        InvincibilityUpgradeNumber,
                        MagnetUpgradeNumber,
                        ChestUpgradeNumber,
                        (int)vehicles[0].getHandlingPlus(),
                        (int)vehicles[0].getLuckPlus(),
                        (int)(vehicles[0].getSizePlus()),
                        (int)vehicles[0].getArmourPlus(),
                        (int)vehicles[1].getHandlingPlus(),
                        (int)vehicles[1].getLuckPlus(),
                        (int)(vehicles[1].getSizePlus()),
                        (int)vehicles[1].getArmourPlus(),
                        (int)vehicles[2].getHandlingPlus(),
                        (int)vehicles[2].getLuckPlus(),
                        (int)(vehicles[2].getSizePlus()),
                        (int)vehicles[2].getArmourPlus(),
                        (int)vehicles[0].getBought(),
                        (int)(vehicles[1].getBought()),
                        (int)vehicles[2].getBought(),
                        missionProgress[0],
                        missionProgress[1],
                        missionProgress[2],
                        missionProgress[3],
                        missionProgress[4],
                        (int)selectedMission[0],
                        (int)selectedMission[1],
                        (int)selectedMission[2]
                };
        */
/*
        int c=0;
        for (c=0;c<gold_object.length;c++){
            goldx[c]=0;
            goldy[c]=0;
            goldz[c]=-100f;
            goldvx[c]=0;
            goldvy[c]=0;
            goldvz[c]=0;




            goldWantSpawned[c] =false;
        }





        for (c=0;c<BOD.length;c++){
            BODx[c]=1000f;
            BODy[c]=0;
            BODz[c]=-100f;
            BODvx[c]=(float)Math.random()*1f;
            BODvy[c]=(float)Math.random()*1f;
            BODvz[c]=0;


            BODinAttackMode[c] =false;
            BODWantSpawned[c] =false;
        }



        for (c=0;c<rocket.length;c++){
            rocketx[c]=1000f;
            rockety[c]=0;
            rocketz[c]=-100f;
            rocketvx[c]=0;
            rocketvy[c]=0;
            rocketvz[c]=0;


            inAttackMode[c]=false;
            rocketWantSpawned[c]=false;
        }


        for (c=0;c<RX.length;c++){
            RX[c]=(float) Math.random()* CV.WidthOfLevels-CV.WidthOfLevels/2;
            RY[c]=(float) Math.random()*CV.HeightOfLevels-CV.HeightOfLevels/2;
            RZ[c]=-vz+30*c+ ((float)Math.random())*100;
            rock[c]= new Rock(gl,RX[c],RY[c],RZ[c]);
        }
*/


        //  co=new Collisions();
        //for (int z=0;z<upgrades.length;z++){upgrades[z]=0;}


        pauseMenuActivated=false;


        //rotation=gold_object.length;

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);


        gold=0;//TODO change this
        setAllBuffers();


        //r=mVehicleVerts.array();

    }

    //renderController rC=new renderController();


    float increaser=0f;
    float changer=0f;
    public static FloatBuffer mTriangleColorBuffer=null;
    public static FloatBuffer mTriangleUVBuffer=null;
    Gold diamond;

    int c=0;



    public void onDrawFrame(GL10 gl) {

        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);



        //gl.glLoadIdentity();
        float aspect = (float)Screen_Width / Screen_Height;
        gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 1.0f, 500.0f);

        rC.setMR(MR);


        increaser=increaser+0.01f;

        font=new FontClass(gl);
        this.gl = gl;

        setAllBuffers();


        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -3.0f);

        //gl.glTranslatef(0, 0, 0f);

        gl.glRotatef(mAngleX, 1, 0, 0);
        gl.glRotatef(mAngleY+180f, 0, 1, 0);
        gl.glRotatef(mAngleZ, 0, 1, 0);

        changer=changer-0.1f;

        float[] colors={
                (changer)%0.9f+0.1f, (mAngleX/200f)%1f, (mAngleY/100f)%1f,1f,
                (changer*2f)%0.9f+0.1f, (mAngleX/300f)%1f, (mAngleY/200f)%1f,1f,
                (changer*0.2f)%0.9f+0.1f, (mAngleX/20f)%1f, (mAngleY/20f)%1f,1f,
                (changer*0.7f)%0.9f+0.1f, (mAngleX/50f)%1f, (mAngleY/400f)%1f,1f,
                (changer*9f)%0.9f+0.1f, (mAngleX/100f)%1f, (mAngleY/50f)%1f,1f

        };

        float[] UVCoords={
                0,0,  0,1f,  1f,1f,  1f,0f,0f,0f
        };
        setmTriangleUVBuffer(rC.uvBufferGenerator(UVCoords));
        setmTriangleColorBuffer(rC.colorsBufferGenerator(colors));
        //gl.glColor4f((changer) % 0.9f + 0.1f, (mAngleX / 100f) % 1f, (mAngleY / 100f) % 1f, 0);

        //gl.glColor4f(1f,0,1f, 0.5f);

        //font.drawFont(10f-changer,-1,-3f,40f,2f,mContext.getFilesDir().toString().toUpperCase());
        //font.drawFont(10f-changer,-1,-3f,10f,2f,mainString);

        c=c+1;


        //String a=Float.toString(t[c]);

        //String d=Float.toString(r[c]);
        //font.drawFont(10f-changer,-1,-3f,3f,2f,a);

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





        // BOD[0].Render(4f,0,0);
        //w1.Render(1f, true);
        //w2.Render(1f, false);
        //c1.Render(-CV.HeightOfLevels / 2, 0);
        //vehicles[selected_vehicle].Render(2f,2f,0,0,0,0);




        //rock.Render(0,4f,0);
        // power=new PowerUps(gl,0f,-4f,2f,4);

        //menus.AboutUs();

        //menus.VEHICLE_MENU(vehicles[selected_vehicle],selected_vehicle);
        //vehicles[selected_vehicle]=new ElectricRing(gl,2f, 0, 0, 0, 0, 0);

        //rC.drawWithBuffers(gl,true, mVertexBuffer,mTriangleColorBuffer,mTriangleBorderIndicesBuffer,9);



        //fjkf(R.drawable.thecubenametag);

        //rC.drawWithBuffers(gl,mVertexBuffer,mTriangleColorBuffer,mTriangleUVBuffer,mTriangleBorderIndicesBuffer,18,R.drawable.speedyface);

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
            gl.glTranslatef(-1f+(increaser*2f)%2f,0, -0.001f);

            gl.glColor4f(0.8f, 0.3f, 0.2f, 1);
            rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 20);
            //rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 20);


            gl.glPopMatrix();





        }
        gl.glPopMatrix();


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

        // gl.glLoadIdentity();
        //gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 0.0f, 500.0f);

        mouseDownLast=mouseDown;
        mouseDown=false;
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
        Bitmap b = BitmapFactory.decodeResource(getmContext().getResources(), textureName);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, b, 0);



    }
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Screen_Height=height;
        Screen_Width=width;
        gl.glViewport(0, 0, width, height);
        float aspect = (float)width / height;
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 0.0f, 500.0f);

    }

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
    public  boolean onTouchEvent (MotionEvent e){
        //if (!mouseDownLast) {
        //    selected_vehicle = (selected_vehicle + 1) % 3;
        //    setUpVehicleBuffers();
        //}

        float x=e.getX();
        float y = e.getY();


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

        mouseDown=true;
        return true;

    }

    //First declare vertex buffers
    public static FloatBuffer mStandardRectVerts;//
    public static FloatBuffer mWallRectVerts;//
    public static FloatBuffer mWallStripRectVerts;//
    //public FloatBuffer
    public static FloatBuffer mStandardCuboidVerts;//
    public static FloatBuffer mVehicleVerts;//
    public static FloatBuffer mRocketVerts;//
    public static FloatBuffer mBODVerts;//
    public static FloatBuffer mGold1Verts;//
    public static FloatBuffer mGold2Verts;//
    public static FloatBuffer mGold3Verts;//
    public static FloatBuffer mGUItopper;//
    public static FloatBuffer mGUIBigCircleVerts;
    public static FloatBuffer mGUILittleCircleVerts;
    public static FloatBuffer mTagVerts;
    public static FloatBuffer mSmallRectVerts;
    public static FloatBuffer mMidRectVerts;
    public static FloatBuffer mCeilingVerts;


    //Declare color buffers
    public static FloatBuffer mStandardCuboidColor;//
    public static FloatBuffer mVehicleColor;//
    public static FloatBuffer mRocketsColor;//
    public static FloatBuffer mBODColor;//
    // public FloatBuffer mBODColor;
    public static FloatBuffer mGold1Color;//
    public static FloatBuffer mGold2Color;//
    public static FloatBuffer mGold3Color;//
    //Declare texture buffers
    public static FloatBuffer mStandardRectUVCoordsVerts;//
    public static FloatBuffer mUVCoordsStandardCuboid;//

    //Declare indices buffers
    public static ShortBuffer mStandardRectInd;//
    public static ShortBuffer mStandardCuboidInd;//
    public static ShortBuffer mVehicleInd;//
    public static ShortBuffer mRocketInd;//
    public static ShortBuffer mBODInd;//
    public static ShortBuffer mGold1Ind;//
    public static ShortBuffer mGold2Ind;//
    public static ShortBuffer mGold3Ind;//
    public static ShortBuffer mGUICircleInd;


    public static FloatBuffer mVehicleSecondaryVerts;
    public static FloatBuffer mVehicleSecondaryColor;
    public static ShortBuffer mVehicleSecondaryInd;


    //Say what number of indices

    public float xaxis=1f;
    public float yaxis=1f;

MyRenderer MR;
    public void setUpBuffers(){


        rC.setMR(MR);
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
        float radiusBig       =1.0f;
        float radiusLittle    =0.35f;
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



    }
    public void setUpCuboidBuffers(){

        Rock rockel=new Rock();
        rockel.makeEverything();

        setmStandardCuboidVerts(rC.vertexBufferGenerator(rockel.getVertices()));
        setmStandardCuboidColor(rC.colorsBufferGenerator(rockel.getColors()));
        setmStandardCuboidInd(rC.indexBufferGenerator(rockel.getIndices()));

    }

    public void setUpVehicleBuffers(){

        //  vehicles[selected_vehicle].
        //setmVehicleVerts(rC.vertexBufferGenerator(vehicles[selected_vehicle].getModelVertArray() ));
        //  setmVehicleColor(rC.colorsBufferGenerator(vehicles[selected_vehicle].getModelColorArray()));
        // setmVehicleInd(rC.indexBufferGenerator(vehicles[selected_vehicle].getModelIndArray()));

        //vehicles[selected_vehicle].makeEverything();


        //setmVehicleVerts(rC.vertexBufferGenerator(standardRectVerts ));
        //setmVehicleColor(rC.colorsBufferGenerator(standardRectUVCoords));
        //setmVehicleInd  (rC.indexBufferGenerator(standardRectInd));


        setmVehicleVerts(rC.vertexBufferGenerator(vehicles[selected_vehicle].getModelVertArray() ));
        setmVehicleColor(rC.colorsBufferGenerator(vehicles[selected_vehicle].getModelColorArray()));
        setmVehicleInd(rC.indexBufferGenerator(vehicles[selected_vehicle].getModelIndArray()));

        setmVehicleSecondaryVerts(rC.vertexBufferGenerator(vehicles[selected_vehicle].getModel2()));
        setmVehicleSecondaryColor(rC.colorsBufferGenerator(vehicles[selected_vehicle].getModelColor2()));
        setmVehicleSecondaryInd  (rC.indexBufferGenerator(vehicles[selected_vehicle].getModelIndices2()));

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

package com.leaflea.johndoran.projecti;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Scanner;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/**
 * Created by John on 19/09/15.
 */
public class DumpClassFin implements GLSurfaceView.Renderer{
    private static Context mContext;
    private FloatBuffer mVertexBuffer = null;
    private ShortBuffer mTriangleBorderIndicesBuffer = null;
    private int mNumOfTriangleBorderIndices = 0;

    private static int[] mTextureList=null;
	/*
	try {
		File pngImage=new File(file);
		BufferedImage bufImage=ImageIO.read(pngImage);
		File bmpImage=new File("res/bitmap.bmp");
		ImageIO.write(bufImage,"bmp",bmpImage);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/

    //String fileName=new File(getFilesDir(), file).getAbsolutePath();

    //Texture t;
/*
    public static void bindTexture(String file,GLES10 gl){

        Bitmap b=BitmapFactory.decodeFile("res/Bitmaps/"+file);
        glEnable(GL_TEXTURE_2D);

        mTextureList=new int[1];

        GLES10.glGenTextures(1,mTextureList,0);

        GLES10.glTexParameterf(GLES10.GL_TEXTURE_2D, GLES10.GL_TEXTURE_MAG_FILTER, GLES10.GL_LINEAR); //kinda irrelevant
        GLES10.glTexParameterf(GLES10.GL_TEXTURE_2D, GLES10.GL_TEXTURE_MIN_FILTER, GLES10.GL_LINEAR); //kinda irrelevant
        GLES10.glTexEnvf(GLES10.GL_TEXTURE_ENV, GLES10.GL_TEXTURE_ENV_MODE, GLES10.GL_MODULATE);	//kinda irrelevant


        GLES10.glClientActiveTexture(GLES10.GL_TEXTURE0);
        GLES10.glEnableClientState(GLES10.GL_TEXTURE_COORD_ARRAY);
        GLUtils.texImage2D(GLES10.GL_TEXTURE_2D, 0, b, 0);
        b.recycle();


    }
*/

    public static float getXaxis() {
        return xaxis;
    }
    // public static void setXaxis(float xaxis) {
    //     Main.xaxis = xaxis;
    // }
    public static float getYaxis() {
        return yaxis;
    }
    //public static void setYaxis(float yaxis) {
    //    Main.yaxis = yaxis;
    //}
    public static int getScreen_Width() {
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
    }
    public static float getGold() {
        return gold;
    }
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
    }


    public Boolean pauseMenuActivated;
    public static int mx;
    public static int my;

    public static Boolean mouseDown;

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



    public static Menus menus;
    public static float zmov=0f;



    public static float rocketspawnlength=4000f;
    public static float BODspawnlength=2000f;
    public static float goldSpawnLength=100f;
    public static int rotation;
    public static Boolean skipped=true;
    public static int spawnnum;



    public static int counterPopUp=0;
    public static int r=0;
    public static float collisionx=0;
    public static float collisiony=0;
    public static float amountabovecam=5f;
    public static Collisions co;




    public static CentralisedVariables CV;
    //private Enemies[] sj=new The_Cube[10];
    //private Enemies[] sj;

    public static int selected_vehicle=2;

    public static float LengthOfLevels=2400f;
    public static float WidthOfLevels=60f;
    public static float HeightOfLevels=30f;
    public static Boolean WallsNeedReseting=false;

    public static float z1=0f;
    public static float z2=LengthOfLevels;
    public static float z3=LengthOfLevels*2;

    public static float xaxis=0.62f;
    public static float yaxis=0.47f;

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
    public static Vehicles[] vehicles;

    //public static Texture menu;


    public static int goldSpawnNum=0;
    public static float lastGoldSpawnPoint=-100f;
    public static int framesUntilNormal=400;
    public static int framesUntilNormal2=400;


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
    public static int Screen_Width =400 ;
    public static int Screen_Height=300 ;

    public static Boolean MENU_CLICK_ACTIVATED=true;



    public static int numberOfPowerUps=0;
    public static int noc=15;
    public static float[] RX  =new float[noc];
    public static float[] RY  =new float[noc];
    public static float[] RZ  =new float[noc];
    public static Rock[] rock =new Rock[noc];
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

    public static BufferedWriter goldFileWriter;
    public static BufferedReader goldFileReader;
    public static BufferedReader upgradesFileReader;
    public static BufferedWriter upgradesFileWriter;
    public static BufferedReader lastRunFileReader;
    public static BufferedWriter lastRunFileWriter;

    public static BufferedWriter scoreFileWriter;
    public static BufferedReader scoreFileReader;

    public static float[] highScores=new float[10];

    public static Boolean full_screen=true;
    renderController rC=new renderController();
    FontClass FONT;

//////////////////////Copy and paste mark



    public DumpClassFin(Context context) {
        mContext = context;
    }

    public static int[] getmTextureList() {
        return mTextureList;
    }

    public static void setmTextureList(int[] mTextureList) {
        DumpClassFin.mTextureList = mTextureList;
    }

    public static FloatBuffer getmStandardRectVerts() {
        return mStandardRectVerts;
    }

    public static void setmStandardRectVerts(FloatBuffer mStandardRectVerts) {
        DumpClassFin.mStandardRectVerts = mStandardRectVerts;
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
        DumpClassFin.mWallStripRectVerts = mWallStripRectVerts;
    }

    public static FloatBuffer getmStandardCuboidVerts() {
        return mStandardCuboidVerts;
    }

    public static void setmStandardCuboidVerts(FloatBuffer mStandardCuboidVerts) {
        DumpClassFin.mStandardCuboidVerts = mStandardCuboidVerts;
    }

    public static FloatBuffer getmVehicleVerts() {
        return mVehicleVerts;
    }

    public static void setmVehicleVerts(FloatBuffer mVehicleVerts) {
        DumpClassFin.mVehicleVerts = mVehicleVerts;
    }

    public static FloatBuffer getmRocketVerts() {
        return mRocketVerts;
    }

    public static void setmRocketVerts(FloatBuffer mRocketVerts) {
        DumpClassFin.mRocketVerts = mRocketVerts;
    }

    public static FloatBuffer getmBODVerts() {
        return mBODVerts;
    }

    public static void setmBODVerts(FloatBuffer mBODVerts) {
        DumpClassFin.mBODVerts = mBODVerts;
    }

    public static FloatBuffer getmGold1Verts() {
        return mGold1Verts;
    }

    public static void setmGold1Verts(FloatBuffer mGold1Verts) {
        DumpClassFin.mGold1Verts = mGold1Verts;
    }

    public static FloatBuffer getmGold2Verts() {
        return mGold2Verts;
    }

    public static void setmGold2Verts(FloatBuffer mGold2Verts) {
        DumpClassFin.mGold2Verts = mGold2Verts;
    }

    public static FloatBuffer getmGold3Verts() {
        return mGold3Verts;
    }

    public static void setmGold3Verts(FloatBuffer mGold3Verts) {
        DumpClassFin.mGold3Verts = mGold3Verts;
    }

    public static FloatBuffer getmGUItopper() {
        return mGUItopper;
    }

    public static void setmGUItopper(FloatBuffer mGUItopper) {
        DumpClassFin.mGUItopper = mGUItopper;
    }

    public static FloatBuffer getmGUIBigCircleVerts() {
        return mGUIBigCircleVerts;
    }

    public static void setmGUIBigCircleVerts(FloatBuffer mGUIBigCircleVerts) {
        DumpClassFin.mGUIBigCircleVerts = mGUIBigCircleVerts;
    }

    public static FloatBuffer getmGUILittleCircleVerts() {
        return mGUILittleCircleVerts;
    }

    public static void setmGUILittleCircleVerts(FloatBuffer mGUILittleCircleVerts) {
        DumpClassFin.mGUILittleCircleVerts = mGUILittleCircleVerts;
    }

    public static FloatBuffer getmStandardCuboidColor() {
        return mStandardCuboidColor;
    }

    public static void setmStandardCuboidColor(FloatBuffer mStandardCuboidColor) {
        DumpClassFin.mStandardCuboidColor = mStandardCuboidColor;
    }

    public static FloatBuffer getmVehicleColor() {
        return mVehicleColor;
    }

    public static void setmVehicleColor(FloatBuffer mVehicleColor) {
        DumpClassFin.mVehicleColor = mVehicleColor;
    }

    public static FloatBuffer getmRocketsColor() {
        return mRocketsColor;
    }

    public static void setmRocketsColor(FloatBuffer mRocketsColor) {
        DumpClassFin.mRocketsColor = mRocketsColor;
    }

    public static FloatBuffer getmGold1Color() {
        return mGold1Color;
    }

    public static void setmGold1Color(FloatBuffer mGold1Color) {
        DumpClassFin.mGold1Color = mGold1Color;
    }

    public static FloatBuffer getmGold2Color() {
        return mGold2Color;
    }

    public static void setmGold2Color(FloatBuffer mGold2Color) {
        DumpClassFin.mGold2Color = mGold2Color;
    }

    public static FloatBuffer getmGold3Color() {
        return mGold3Color;
    }

    public static void setmGold3Color(FloatBuffer mGold3Color) {
        DumpClassFin.mGold3Color = mGold3Color;
    }

    public static FloatBuffer getmStandardRectUVCoordsVerts() {
        return mStandardRectUVCoordsVerts;
    }

    public static void setmStandardRectUVCoordsVerts(FloatBuffer mStandardRectUVCoordsVerts) {
        DumpClassFin.mStandardRectUVCoordsVerts = mStandardRectUVCoordsVerts;
    }

    public static ShortBuffer getmStandardRectInd() {
        return mStandardRectInd;
    }

    public static void setmStandardRectInd(ShortBuffer mStandardRectInd) {
        DumpClassFin.mStandardRectInd = mStandardRectInd;
    }

    public static ShortBuffer getmStandardCuboidInd() {
        return mStandardCuboidInd;
    }

    public static void setmStandardCuboidInd(ShortBuffer mStandardCuboidInd) {
        DumpClassFin.mStandardCuboidInd = mStandardCuboidInd;
    }

    public static ShortBuffer getmVehicleInd() {
        return mVehicleInd;
    }

    public static void setmVehicleInd(ShortBuffer mVehicleInd) {
        DumpClassFin.mVehicleInd = mVehicleInd;
    }

    public static ShortBuffer getmRocketInd() {
        return mRocketInd;
    }

    public static void setmRocketInd(ShortBuffer mRocketInd) {
        DumpClassFin.mRocketInd = mRocketInd;
    }

    public static ShortBuffer getmBODInd() {
        return mBODInd;
    }

    public static void setmBODInd(ShortBuffer mBODInd) {
        DumpClassFin.mBODInd = mBODInd;
    }

    public static ShortBuffer getmGold1Ind() {
        return mGold1Ind;
    }

    public static void setmGold1Ind(ShortBuffer mGold1Ind) {
        DumpClassFin.mGold1Ind = mGold1Ind;
    }

    public static ShortBuffer getmGold2Ind() {
        return mGold2Ind;
    }

    public static void setmGold2Ind(ShortBuffer mGold2Ind) {
        DumpClassFin.mGold2Ind = mGold2Ind;
    }

    public static ShortBuffer getmGold3Ind() {
        return mGold3Ind;
    }

    public static void setmGold3Ind(ShortBuffer mGold3Ind) {
        DumpClassFin.mGold3Ind = mGold3Ind;
    }

    public static ShortBuffer getmGUICircleInd() {
        return mGUICircleInd;
    }

    public static void setmGUICircleInd(ShortBuffer mGUICircleInd) {
        DumpClassFin.mGUICircleInd = mGUICircleInd;
    }

    public static FloatBuffer getmUVCoordsStandardCuboid() {
        return mUVCoordsStandardCuboid;
    }

    public static void setmUVCoordsStandardCuboid(FloatBuffer mUVCoordsStandardCuboid) {
        DumpClassFin.mUVCoordsStandardCuboid = mUVCoordsStandardCuboid;
    }

    public static FloatBuffer getmTagVerts() {
        return mTagVerts;
    }

    public static void setmTagVerts(FloatBuffer mTagVerts) {
        DumpClassFin.mTagVerts = mTagVerts;
    }

    public static FloatBuffer getmSmallRectVerts() {
        return mSmallRectVerts;
    }

    public static void setmSmallRectVerts(FloatBuffer mSmallRectVerts) {
        DumpClassFin.mSmallRectVerts = mSmallRectVerts;
    }

    public static FloatBuffer getmMidRectVerts() {
        return mMidRectVerts;
    }

    public static void setmMidRectVerts(FloatBuffer mMidRectVerts) {
        DumpClassFin.mMidRectVerts = mMidRectVerts;
    }

    public static FloatBuffer getmCeilingVerts() {
        return mCeilingVerts;
    }

    public static void setmCeilingVerts(FloatBuffer mCeilingVerts) {
        DumpClassFin.mCeilingVerts = mCeilingVerts;
    }

    public static FloatBuffer getmVehicleSecondaryVerts() {
        return mVehicleSecondaryVerts;
    }

    public static void setmVehicleSecondaryVerts(FloatBuffer mVehicleSecondaryVerts) {
        DumpClassFin.mVehicleSecondaryVerts = mVehicleSecondaryVerts;
    }

    public static FloatBuffer getmVehicleSecondaryColor() {
        return mVehicleSecondaryColor;
    }

    public static void setmVehicleSecondaryColor(FloatBuffer mVehicleSecondaryColor) {
        DumpClassFin.mVehicleSecondaryColor = mVehicleSecondaryColor;
    }

    public static ShortBuffer getmVehicleSecondaryInd() {
        return mVehicleSecondaryInd;
    }

    public static void setmVehicleSecondaryInd(ShortBuffer mVehicleSecondaryInd) {
        DumpClassFin.mVehicleSecondaryInd = mVehicleSecondaryInd;
    }


    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);	         //  kinda  irrelevant
        mTextureList=new int[1];

        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl.glGenTextures(1, mTextureList, 0);
        gl.glClientActiveTexture(GL10.GL_TEXTURE0);


        FONT=new FontClass(gl);

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);



        gl.glEnable(GL10.GL_BLEND);
        //glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        //glBlendFunc(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
        gl.glMatrixMode(GL10.GL_PROJECTION); //Will not run if not static!!!(Import + method)
        gl.glLoadIdentity();
        //glOrtho(0,Display.getWidth(),0,Display.getHeight(), -100,100);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glClearColor(0, 0, 0, 1); // red,blue,green,opaqueness(spelling?!) done every time dispalay clears



        // Get all the buffers ready
        //setUpAllBuffers();

        //scores=new File(mContext.getFilesDir()+"/scores.txt");
        setUpBuffers();
        completedMission[0]=99;
        completedMission[1]=99;
        completedMission[2]=99;


////////////////////////////////////havent added in from here to
        try {

            //goldFileWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("goldValue.txt",false)));


            goldFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/goldValue.txt")));
            scoreFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/highScores.txt")));
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

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        String s;
        try{
            gold =Float.parseFloat(goldFileReader.readLine());
            goldFileReader.close();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String l;
        int counterh=0;
        try {
            while((l=scoreFileReader.readLine())!=null){
                highScores[counterh]=Float.parseFloat(l);
                counterh++;
            }
            Arrays.sort(highScores);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            scoreFileReader.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        ////////////////////////////////////TODO havent added in until here

        for (int c=0;c<respawneverything.length;c++){
            respawneverything[c]=true;
        }
        vehicles=new Vehicles[9];
        CV=new CentralisedVariables();
        rC.giveContext(mContext);//////////////////Did not add in
        vehicles[0]=new The_Cube(gl);
        vehicles[1]=new Motor(gl);
        vehicles[2]=new ElectricRing(gl);

        /*
        maybe use the other initialisation (without arguments) here????
         */

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

        String st;


        pauseMenuActivated=false;
        int counterUpgrades=0;
        try {
            upgradesFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/upgrades.txt")));

            try {
                while((st=upgradesFileReader.readLine())!=null){
                    //st=upgradesFileReader.readLine();
                    upgrades[counterUpgrades]=Integer.parseInt(st);
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

        File fi=new File(mContext.getFilesDir()+"/upgrades.txt");
        fi.delete();


        frequencyUpgradeNumber=(int) upgrades[0];
        SpeedyUpgradeNumber=(int) upgrades[1];
        InvincibilityUpgradeNumber=(int) upgrades[2];
        MagnetUpgradeNumber=(int) upgrades[3];
        ChestUpgradeNumber=(int) upgrades[4];
        vehicles[0].setHandlingPlus((float)upgrades[5]);
        vehicles[0].setLuckPlus((float)upgrades[6]);
        vehicles[0].setSizePlus((float)((float)upgrades[7]));
        vehicles[0].setArmourPlus((float)upgrades[8]);
        vehicles[1].setHandlingPlus((float)upgrades[9]);
        vehicles[1].setLuckPlus((float)upgrades[10]);
        vehicles[1].setSizePlus((float)upgrades[11]);
        vehicles[1].setArmourPlus((float)upgrades[12]);
        vehicles[2].setHandlingPlus((float)upgrades[13]);
        vehicles[2].setLuckPlus((float)upgrades[14]);
        vehicles[2].setSizePlus((float)upgrades[15]);
        vehicles[2].setArmourPlus((float)upgrades[16]);
        vehicles[0].setBought((int)upgrades[17]);
        vehicles[1].setBought((int)upgrades[18]);
        vehicles[2].setBought((int)upgrades[19]);
        missionProgress[0]=  (int) upgrades[20];
        missionProgress[1]=  (int) upgrades[21];
        missionProgress[2]=  (int) upgrades[22];
        missionProgress[3]=  (int) upgrades[23];
        missionProgress[4]=  (int) upgrades[24];
        selectedMission[0]=  (int) upgrades[25];
        selectedMission[1]=  (int) upgrades[26];
        selectedMission[2]=  (int) upgrades[27];
        //upgradesFileReader



        //Camera cam= new Camera(60, (float)Display.getWidth()/(float)Display.getHeight(), 0.8f, 3200);


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



        co=new Collisions();

    /*
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("res/01 Digitall.ttf");

            java.awt.Font awtFont2 = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, inputStream);
            font = new TrueTypeFont(awtFont2, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    */
    /*
        java.awt.Font font1 = new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,24);
        font=new TrueTypeFont(font1,false);

        java.awt.Font font21 = new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,60);
        font2=new TrueTypeFont(font21,false);
    */


        rotation=gold_object.length;
        Arrays.sort(highScores);///TODO add in
        menus=new Menus(gl);
        Reset();

    }

    private GL10 gl;



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



    MyRenderer MR;
    //Say what number of indices
    public void setUpBuffers(){

        rC.setMR(MR);
        //Methodology
        //
        //All building blocks of buffers will be got from the appropriate class.
        //renderController methods will be called in the appropriate classes however
        //all buffers will be stored in MyRenderer classs.
        //
        //
        float[] standardRectVerts={
                -xaxis, yaxis,0,
                -xaxis,-yaxis,0,
                xaxis,-yaxis,0,
                xaxis, yaxis,0
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

        setmWallRectVerts(rC.vertexBufferGenerator(makeFloatVerts(CV.HeightOfLevels, CV.LengthOfLevels / 30f)));
        setmWallStripRectVerts(rC.vertexBufferGenerator(makeFloatVerts(CV.HeightOfLevels / 6f, CV.LengthOfLevels / 30f)));
        setmGUItopper(rC.vertexBufferGenerator(makeFloatVerts(xaxis * 2f, yaxis * 0.4f)));

        menus.makeAllVerts();
        setmTagVerts(rC.vertexBufferGenerator(menus.getTagVerts()));
        setmSmallRectVerts(rC.vertexBufferGenerator(menus.getSmallRects()));
        setmMidRectVerts(rC.vertexBufferGenerator(menus.getMidSizeRect()));

        Ceiling_plain c=new Ceiling_plain();
        c.makeEverything();
        setmCeilingVerts(rC.vertexBufferGenerator(c.getCeilVerts()));


    }

    public void setUpRocketAndBODBuffers(){
        BallOfDeath bod=new BallOfDeath();
        bod.makeEverything();
        setmBODVerts(rC.vertexBufferGenerator(bod.getVertices()));
        setmBODInd(rC.indexBufferGenerator(bod.getIndices()));


        Rocket boom=new Rocket();

        boom.makeEverything();
        setmRocketVerts(rC.vertexBufferGenerator(boom.getVertices()));
        setmRocketsColor(rC.colorsBufferGenerator(boom.getColors()));
        setmRocketInd(rC.indexBufferGenerator(boom.getIndices()));
    }
    public void setUpGUI(){
        float radiusBig       =0.15f;
        float radiusLittle    =0.05f;
        int sides=20;

        short[] circleIndices=new short[20*3];
        for(int c=0;c<sides;c++){

            circleIndices[c*3+0]=0;
            circleIndices[c*3+1]=(short)((c)%sides);
            circleIndices[c*3+2]=(short)((c+1)%sides);

        }

        setmGUICircleInd(rC.indexBufferGenerator(circleIndices));


        float[] circleBigVerts=new float[(sides+1)*3];
        float[] circleLittleVerts=new float[(sides+1)*3];

        float tempx;
        float tempy;
        circleBigVerts[0]=0;
        circleBigVerts[1]=0;
        circleBigVerts[2]=0;

        for (int c=1;c<(sides+1);c++){
            tempx=((float)(c-1)*radiusBig)/(float)sides*2f-radiusBig;
            tempy=radiusBig*radiusBig-tempx*tempx;
            circleBigVerts[c*3+0]=tempx;
            circleBigVerts[c*3+1]=tempy;
            circleBigVerts[c*3+2]=0;

            circleBigVerts[(c+sides/2)*3+0]=-tempx;
            circleBigVerts[(c+sides/2)*3+1]=-tempy;
            circleBigVerts[(c+sides/2)*3+2]=0;
        }


        circleLittleVerts[0]=0;
        circleLittleVerts[1]=0;
        circleLittleVerts[2]=0;

        for (int c=1;c<(sides+1);c++){
            tempx=((float)(c-1)*radiusLittle)/(float)sides*2f-radiusLittle;
            tempy=radiusLittle*radiusLittle-tempx*tempx;
            circleLittleVerts[c*3+0]=tempx;
            circleLittleVerts[c*3+1]=tempy;
            circleLittleVerts[c*3+2]=0;

            circleLittleVerts[(c+sides/2)*3+0]=-tempx;
            circleLittleVerts[(c+sides/2)*3+1]=-tempy;
            circleLittleVerts[(c+sides/2)*3+2]=0;
        }

        setmGUIBigCircleVerts(rC.vertexBufferGenerator(circleBigVerts));
        setmGUILittleCircleVerts(rC.vertexBufferGenerator(circleLittleVerts));



    }
    public void setUpCuboidBuffers(){

        Rock rockel=new Rock();
        rockel.makeEverything();

        setmStandardCuboidVerts(rC.vertexBufferGenerator  (rockel.getVertices()));
        setmStandardCuboidColor(rC.colorsBufferGenerator  (rockel.getColors()));
        setmStandardCuboidInd(rC.indexBufferGenerator   (rockel.getIndices()));

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

    public  boolean onTouchEvent (MotionEvent e){
        mx=(int)e.getX();
        my = (int)e.getY();
        mouseDown=true;
        return true;

    }
    public void onDrawFrame(GL10 gl) {

        this.gl=gl;
        rC.setMR(MR);
       /* gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, 0.0f, -3.0f);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

        // Set line color to green
        gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);

        // Draw all lines
        gl.glDrawElements(GL10.GL_LINES, mNumOfTriangleBorderIndices,
                GL10.GL_UNSIGNED_SHORT, mTriangleBorderIndicesBuffer);*/
        int c=0;
       // Camera cam= new Camera(gl,60, (float)4/(float)3, 0.8f, 3200);

        /*
        mouseDown=Mouse.isButtonDown(0);
        mx=Mouse.getX();
        my=Mouse.getY();
        */

        if (option==0){

            if (menuoption==99&&completedMission[0]==99&&completedMission[1]==99&&completedMission[2]==99){

                menuoption=9;

            }


            gl.glDisable(GLES10.GL_DEPTH_TEST);

            gl.glPushMatrix();



            //glOrtho(0,(double)Display.getWidth(),0,(double)Display.getHeight(), -1d,10d);
            //gluOrtho2D(0,Display.getWidth(),0,Display.getHeight());
            if (mouseDown==false){
                MENU_CLICK_ACTIVATED=true;
            }
            //cam.useView(0,0,0,0,0,0);
            gl.glLoadIdentity();

            gl.glMatrixMode(GLES10.GL_PROJECTION);
            gl.glEnable(GLES10.GL_TEXTURE);
            gl.glColor4f(0.5f, 1f, 1f, 1f);

            ///////////////////
            ////////////////////
            //////////messed up here with translatef
            /////////////////////
            ////////////////////

            if(que){
                gl.glTranslatef(0, 0, -0.8f);

                que=false;
            }
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glEnable(GL10.GL_TEXTURE_2D);
            //glMatrixMode (GL_MODELVIEW);

            //	glDisable(GL_DEPTH_TEST);

            gl.glEnable(GL10.GL_BLEND);

            gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


            if (menuoption==0){
                menus.MainMenu();
                //   font.drawString(2, 2, "0", Color.white);
                // glRotatef(1f,0,1f,0);




            }else if (menuoption==1){
                menus.Custom();
            }else if(menuoption==11){
                //menus.VEHICLE_OVERVIEW_MENU();

            }
            else if(menuoption==111){

                menus.VEHICLE_MENU(vehicles[selected_vehicle],selected_vehicle);
                //menus.TICK_ICON();
            }
            else if(menuoption==21){
                menus.POWERUPS_MENU();
            }else if (menuoption==2){
                menus.HighScores();
            }else if (menuoption==3){
                menus.AboutUs();
            }


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
            if(MENU_CLICK_ACTIVATED){
                if (mouseDown){
                    if (menuoption==1||menuoption==2||menuoption==3){
                        if ((float)Screen_Width/512f*50f<mx&&mx<(float)Screen_Width/512f*100f){
                            if ((float)(Screen_Height)/512f*50f<my&&my<(float)Screen_Height/512f*100f){
                                menuoption=0;
                                MENU_CLICK_ACTIVATED=false;
                            }
                        }}
                    if (menuoption==21){


                    }
                    if (menuoption==11){
                        if ((float)Screen_Width/512f*70f<mx&&mx<(float)Screen_Width/512f*230f){
                            int w=0;
                            if ((float)(Screen_Height)-(float)(Screen_Height)/512f*(((80f+menus.getHeightOfTags()+(float)0*menus.getDistanceFromTopToTop())))<my&&my<(float)(Screen_Height)-(float)(Screen_Height)/512f*(((80f+0+(float)0*menus.getDistanceFromTopToTop())))) {
                                selected_vehicle=w;
                                lives=resetLives+(int)(vehicles[selected_vehicle].getArmour()+vehicles[selected_vehicle].getArmourPlus());
                                menuoption=111;
                                MENU_CLICK_ACTIVATED=false;

                            }
                            w=w+1;
                            if ((float)(Screen_Height)-(float)(Screen_Height)/512f*(((80f+menus.getHeightOfTags()+(float)1*menus.getDistanceFromTopToTop())))<my&&my<(float)(Screen_Height)-(float)(Screen_Height)/512f*(((80f+0+(float)1*menus.getDistanceFromTopToTop())))) {
                                selected_vehicle=w;
                                lives=resetLives+(int)(vehicles[selected_vehicle].getArmour()+vehicles[selected_vehicle].getArmourPlus());

                                menuoption=111;

                                MENU_CLICK_ACTIVATED=false;

                            }
                            w=w+1;
                            if ((float)(Screen_Height)-(float)(Screen_Height)/512f*(((80f+menus.getHeightOfTags()+(float)2*menus.getDistanceFromTopToTop())))<my&&my<(float)(Screen_Height)-(float)(Screen_Height)/512f*(((80f+0+(float)2*menus.getDistanceFromTopToTop())))) {

                                selected_vehicle=w;
                                lives=resetLives+(int)(vehicles[selected_vehicle].getArmour()+vehicles[selected_vehicle].getArmourPlus());

                                menuoption=111;
                                MENU_CLICK_ACTIVATED=false;

                            }


                        }
                    }
                    if(menuoption==0){

                        if ((float)Screen_Width/512f*160f<mx&&mx<(float)Screen_Width/512f*350f){

                            if ((float)(Screen_Height)/512f*352f<my&&my<(float)Screen_Height/512f*412f){
                                option=1;
                                if (vehicles[selected_vehicle].getBought()!=1){
                                    selected_vehicle=0;

                                }
                                MENU_CLICK_ACTIVATED=false;
                                lives=resetLives+(int)(vehicles[selected_vehicle].getArmourPlus()+vehicles[selected_vehicle].getArmour());

                            }

                            if ((float)(Screen_Height)/512f*262f<my&&my<(float)Screen_Height/512f*322f){
                                menuoption=1;
                                MENU_CLICK_ACTIVATED=false;

                            }

                            if ((float)(Screen_Height)/512f*172f<my&&my<(float)Screen_Height/512f*232f){
                                menuoption=2;
                                MENU_CLICK_ACTIVATED=false;

                            }

                            if ((float)(Screen_Height)/512f*82f<my&&my<(float)Screen_Height/512f*142f){
                                menuoption=3;
                                MENU_CLICK_ACTIVATED=false;

                            }

                        }



                    }}
                if(MENU_CLICK_ACTIVATED){
                    if (mouseDown){
                        if (menuoption==21){
                            if ((float)Screen_Width/512f*120f<mx&&mx<(float)Screen_Width/512f*1700f){
                                if ((float)(Screen_Height)/512f*377f<my&&my<(float)Screen_Height/512f*427f){
                                    if (frequencyUpgradeNumber<5&&gold>200*(int)Math.pow(2, frequencyUpgradeNumber)){
                                        gold=gold-200*(int)Math.pow(2, frequencyUpgradeNumber);
                                        frequencyUpgradeNumber=frequencyUpgradeNumber+1;

                                    }
                                    MENU_CLICK_ACTIVATED=false;

                                }
                                if ((float)(Screen_Height)/512f*307f<my&&my<(float)Screen_Height/512f*357f){
                                    if (SpeedyUpgradeNumber<5&&gold>100*(int)Math.pow(2, SpeedyUpgradeNumber)){
                                        gold=gold-100*(int)Math.pow(2, SpeedyUpgradeNumber);
                                        SpeedyUpgradeNumber++;

                                    }
                                    MENU_CLICK_ACTIVATED=false;
                                }
                                if ((float)(Screen_Height)/512f*237f<my&&my<(float)Screen_Height/512f*287f){
                                    if (InvincibilityUpgradeNumber<5&&gold>100*(int)Math.pow(2, InvincibilityUpgradeNumber)){
                                        gold=gold-100*(int)Math.pow(2, InvincibilityUpgradeNumber);
                                        InvincibilityUpgradeNumber++;
                                    }
                                    MENU_CLICK_ACTIVATED=false;
                                }
                                if ((float)(Screen_Height)/512f*167f<my&&my<(float)Screen_Height/512f*217f){
                                    if (MagnetUpgradeNumber<5&&gold>100*(int)Math.pow(2, MagnetUpgradeNumber)){
                                        gold=gold-100*(int)Math.pow(2, MagnetUpgradeNumber);
                                        MagnetUpgradeNumber++;
                                    }
                                    MENU_CLICK_ACTIVATED=false;
                                }
                                if ((float)(Screen_Height)/512f*97f<my&&my<(float)Screen_Height/512f*147f){
                                    if (ChestUpgradeNumber<5&&gold>100*(int)Math.pow(2, ChestUpgradeNumber)){
                                        gold=gold-100*(int)Math.pow(2, ChestUpgradeNumber);
                                        ChestUpgradeNumber++;
                                    }
                                    MENU_CLICK_ACTIVATED=false;
                                }


                            }


                        }
                        if (menuoption==111){

                            if((float)Screen_Width/512f*512f*0.86f<mx&&mx<(float)Screen_Width/512f*512f*0.985f)
                            {if((float)Screen_Width/512f*512f*0.81f<mx&&mx<(float)Screen_Width/512f*512f*0.935f){
                                if(vehicles[selected_vehicle].getBought()==0&&gold>vehicles[selected_vehicle].getPrice()){

                                    gold=gold-vehicles[selected_vehicle].getPrice();
                                    vehicles[selected_vehicle].setBought(1);

                                }

                                MENU_CLICK_ACTIVATED=false;
                            }}


                            if ((float)Screen_Width/512f*205f<mx&&mx<(float)Screen_Width/512f*240f){
                                if ((float)(Screen_Height)/512f*40f<my&&my<(float)Screen_Height/512f*75f){
                                    if (vehicles[selected_vehicle].getArmourPlus()<6   &&gold>100f*(float)Math.pow(2d, (double)vehicles[selected_vehicle].getArmourPlus())){
                                        gold=gold-100f*(float)Math.pow(2d, (double)(vehicles[selected_vehicle].getArmourPlus()));
                                        vehicles[selected_vehicle].setArmourPlus(vehicles[selected_vehicle].getArmourPlus()+1f);

                                    }

                                    MENU_CLICK_ACTIVATED=false;
                                    vehicles[selected_vehicle].setNotInitialized(true);

                                }
                                if ((float)(Screen_Height)/512f*130f<my&&my<(float)Screen_Height/512f*165f){
                                    if ((double)vehicles[selected_vehicle].getSizePlus()<6   &&gold>100f*(float)Math.pow(2d, (double)vehicles[selected_vehicle].getSizePlus())){
                                        gold=gold-100f*(float)Math.pow(2d, (double)(vehicles[selected_vehicle].getSizePlus()));
                                        vehicles[selected_vehicle].setSizePlus(vehicles[selected_vehicle].getSizePlus()+1f);
                                        vehicles[selected_vehicle].redoInitialisation();
                                    }


                                    MENU_CLICK_ACTIVATED=false;
                                    vehicles[selected_vehicle].setNotInitialized(true);
                                }
                                if ((float)(Screen_Height)/512f*214f<my&&my<(float)Screen_Height/512f*250f){
                                    if (vehicles[selected_vehicle].getLuckPlus()<6   &&gold>100f*(float)Math.pow(2d, (double)vehicles[selected_vehicle].getLuckPlus())){
                                        gold=gold-100f*(float)Math.pow(2d, (double)(vehicles[selected_vehicle].getLuckPlus()));
                                        vehicles[selected_vehicle].setLuckPlus(vehicles[selected_vehicle].getLuckPlus()+1f);
                                        vehicles[selected_vehicle].setNotInitialized(true);
                                    }


                                    MENU_CLICK_ACTIVATED=false;
                                    vehicles[selected_vehicle].setNotInitialized(true);
                                }
                                if ((float)(Screen_Height)/512f*300f<my&&my<(float)Screen_Height/512f*340f){
                                    if (vehicles[selected_vehicle].getHandlingPlus()<6   &&gold>100f*(float)Math.pow(2d, (double)vehicles[selected_vehicle].getHandlingPlus())){
                                        gold=gold-100f*(float)Math.pow(2d, (double)(vehicles[selected_vehicle].getHandlingPlus()));
                                        vehicles[selected_vehicle].setHandlingPlus(vehicles[selected_vehicle].getHandlingPlus()+1f);
                                    }
                                    MENU_CLICK_ACTIVATED=false;
                                    vehicles[selected_vehicle].setNotInitialized(true);
                                }


                            }
                        }

                        if (menuoption==11){
                            if ((float)Screen_Width/512f*50f<mx&&mx<(float)Screen_Width/512f*100f){
                                if ((float)(Screen_Height)/512f*50f<my&&my<(float)Screen_Height/512f*100f){
                                    menuoption=1;
                                    MENU_CLICK_ACTIVATED=false;
                                }

                            }

                        }
                        if (menuoption==111||menuoption==211){
                            if ((float)Screen_Width/512f*50f<mx&&mx<(float)Screen_Width/512f*100f){
                                if ((float)(Screen_Height)/512f*50f<my&&my<(float)Screen_Height/512f*100f){
                                    menuoption=11;
                                    MENU_CLICK_ACTIVATED=false;
                                }

                            }
                            //if ((float)Display.getWidth()/512f*50f<mx&&mx<(float)Display.getWidth()/512f*100f){
                            //	if ((float)(Display.getHeight())/512f*50f<my&&my<(float)Display.getHeight()/512f*100f){
                            //		menuoption=11;
                            //		MENU_CLICK_ACTIVATED=false;
                            //	}

                            //}

                        }
                        if (menuoption==21){
                            if ((float)Screen_Width/512f*50f<mx&&mx<(float)Screen_Width/512f*100f){
                                if ((float)(Screen_Height)/512f*50f<my&&my<(float)Screen_Height/512f*100f){
                                    menuoption=1;
                                    MENU_CLICK_ACTIVATED=false;
                                }

                            }}
                        if (menuoption==1){


                            if ((float)Screen_Width/512f*80f<mx&&mx<(float)Screen_Width/512f*428f){
                                if ((float)(Screen_Height)/512f*332f<my&&my<(float)Screen_Height/512f*432f){
                                    menuoption=11;
                                    MENU_CLICK_ACTIVATED=false;


                                }
                                if ((float)(Screen_Height)/512f*192f<my&&my<(float)Screen_Height/512f*292f){
                                    menuoption=21;
                                    MENU_CLICK_ACTIVATED=false;

                                }
                            }

                        }
                        if (menuoption==9){
                            menuoption=0;
                            MENU_CLICK_ACTIVATED=false;
                        }
                        if (menuoption==99){
                            for (int c4=0;c4<completedMission.length;c4++){
                                completedMission[c4]=99;
                            }
                            menuoption=9;
                            MENU_CLICK_ACTIVATED=false;



                        }

                    }}


            }

            //Display.update();
            //glClear(GL_DEPTH_BUFFER_BIT);
            //Display.update();


            //glOrtho(1,-1,1,-1,-1500,1500);
            gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);
            gl.glEnable(GL10.GL_BLEND);
            gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

            gl.glEnable(GL10.GL_TEXTURE_2D);
            gl.glPushMatrix();{

                gl.glRotatef(180f, 0, 0, 1);//Rotate text so that it is not upside down and the wrong way around.
                gl.glRotatef(180f, 0, 1, 0);
                gl.glTranslatef(0, 0, 980f / 750f * 750f);
		    			/*
		    			 *
		    			 * By the way:
		    			 * 1. y-axis inverted
		    			 * 2. x-axis point
		    			 *
		    			 */



                //font2.drawString(-750f, -568, "GOLD - $"+(int)gold, Color.cyan);

                if (menuoption==111){

                    if (vehicles[selected_vehicle].getBought()==1){
                        //font2.drawString(565f, -358, "$"+(int)vehicles[selected_vehicle].getPrice(),Color.black);
                    }else{
                        //font2.drawString(565f, -358, "$"+(int)vehicles[selected_vehicle].getPrice(),Color.yellow);

                    }


                    //font2.drawString(-335f, -168, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getHandlingPlus()))*100, Color.black);
                    //font2.drawString(-335f, 25, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getLuckPlus()))*100, Color.black);
                    //font2.drawString(-335f, 215, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getSizePlus()))*100, Color.black);
                    //font2.drawString(-335f, 410, "$"+(int)Math.pow(2d,(double)(vehicles[selected_vehicle].getArmourPlus()))*100, Color.black);
                }
                if (menuoption==21){

                    //font2.drawString(-570f, -368, "$"+(int)200*(int)Math.pow(2, frequencyUpgradeNumber), Color.black);
                    //font2.drawString(-570f, -210, "$"+(int)100*(int)Math.pow(2, SpeedyUpgradeNumber), Color.black);
                    //font2.drawString(-570f, -45, "$"+(int)100*(int)Math.pow(2, InvincibilityUpgradeNumber), Color.black);
                    //font2.drawString(-570f, 110, "$"+(int)100*(int)Math.pow(2, MagnetUpgradeNumber), Color.black);
                    //font2.drawString(-570f, 260, "$"+(int)100*(int)Math.pow(2, ChestUpgradeNumber), Color.black);
                }

                if (menuoption==2){
                    for (c=0;c<highScores.length;c++){
                        if (c<(9)){
                            //font2.drawString(-570f, -360+(float)c*70f, (c+1)+".  "+"  "+Integer.toString((int)highScores[highScores.length-1-c]), Color.red);
                        }else{
                            //font2.drawString(-570f, -360+(float)c*70f, (c+1)+".  "+""+Integer.toString((int)highScores[highScores.length-1-c]), Color.red);


                        }
                    }
                }

                if (menuoption== 9){
                    try {
                        lastRunFileReader=new BufferedReader(new InputStreamReader(new FileInputStream(mContext.getFilesDir()+"/lastRun.txt")));

                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    String[] hold= new String[9];
                    String[] holder={"DISTANCE                         : ","GOLD                                  : ","SCORE                                : ","Power Ups                                     : "};
                    int p=0;
                    try {
                        while((hold[p]=lastRunFileReader.readLine())!=null){
                            if (p==3){
                                //font2.drawString(-570f, -360+(float)p*100f,    ("EXTRA GOLD                    : "+(int)(Float.parseFloat(hold[0])*0.01f)), Color.red);
                                //font2.drawString(-570f, -360+(float)(p+1)*100f, "TOTAL GOLD EARNED   : "+(int)(Float.parseFloat(hold[1])+Float.parseFloat(hold[0])*0.01f), Color.red);


                            }else{
                                // font2.drawString(-570f, -360+(float)p*100f, (holder[p]+hold[p]), Color.red);
                            }
                            p++;
                        }
                        //font2.drawString(-570,460,"",Color.orange);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    for ( c=0;c<selectedMission.length;c++){
                        int mission=selectedMission[c];
                        //font2.drawString(-570f, 180+(c)*100, missionTitles[mission]+"  "+missionUpgradeTitles[missionProgress[mission]], Color.orange);
                        String description="error-3";
                        switch(selectedMission[c]){
                            case 0:
                                description=(150+missionProgress[selectedMission[c]]*50)+" metres"    +"    REWARD : "+(250*(missionProgress[selectedMission[c]]+1));
                                break;
                            case 1:
                                description=(1000+missionProgress[selectedMission[c]]*1000)+" points"+"    REWARD : "+(250*(missionProgress[selectedMission[c]]+1));
                                break;
                            case 2:
                                description=Integer.toString((50+missionProgress[selectedMission[c]]*50))+" Gold"+"    REWARD : "+(250*(missionProgress[selectedMission[c]]+1));
                                break;
                            case 3:
                                description=(3+missionProgress[selectedMission[c]])+" Power-Ups"+"    REWARD : "+(250*(missionProgress[selectedMission[c]]+1));
                                break;
                            case 4:
                                description=(1000+missionProgress[selectedMission[c]]*400)+" metres"+"    REWARD : "+(250*(missionProgress[selectedMission[c]]+1));
                                break;
                            default:

                                break;
                        }
                        // font.drawString(-570f, 180+c*100+60, missionDescriptions[mission]+description , Color.orange);


                    }

                }

                if (menuoption==99){
                    //font2.drawString(-570f, -300, "MISSION SUCCESS!!!!!!", Color.green);
                    for (int c4=0;c4<completedMission.length;c4++){
                        if(completedMission[c4]!=99){
                            //font2.drawString(-570f, 180+(c4)*100, missionTitles[completedMission[c4]]+"  "+missionUpgradeTitles[missionProgress[completedMission[c4]]-1], Color.green);
                            //font.drawString(-570f, 180+(c4)*100+70, "REWARD : "+(250*(missionProgress[completedMission[c4]]+1)), Color.green);

                        }
                    }




                }





                //font.drawString(-0f, -570, "THE LIGHTWEIGHT JAVA GAMES LIBRARY", Color.pink);
            }gl.glPopMatrix();

            // Text for menus.




            gl.glDisable(GL10.GL_TEXTURE_2D);


            gl.glMatrixMode(GL10.GL_MODELVIEW);
            // Display.update();//////////////////////////////////////////////////
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
            gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);

            //Display.sync(40);
            //glMatrixMode (GL_PROJECTION);


            gl.glPopMatrix();
            //glMatrixMode (GL_PROJECTION);

            gl.glDisable(GL10.GL_BLEND);
            ResetMenu();

        }








	    		/*
	    		 *
	    		 *
	    		 *
	    		 *
	    		 *
	    		 *
	    		 * Game
	    		 *
	    		 *
	    		 *
	    		 *
	    		 *
	    		 *
	    		 */

        if (option==1) {

            if (pauseMenuActivated==false){
                if (goldThisTurn == 0) {
                    vzBeforeFirstGold = vz;

                }
                if (numberOfPowerUps == 0) {
                    vzBeforeFirstPowerUp = vz;
                }

                if (vz > Checkpoint2) {
                    PLATINUMAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 30f + CheckpointPLATINUMbonus2;
                    DIAMONDAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 60f + CheckpointDIAMONDbonus2;
                } else if (vz > Checkpoint1) {
                    PLATINUMAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 30f + CheckpointPLATINUMbonus1;
                    DIAMONDAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 60f + CheckpointDIAMONDbonus1;
                } else {
                    PLATINUMAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 30f;
                    DIAMONDAbundance = 0 + (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus()) / 60f;
                }

                System.out.println(vehicles[selected_vehicle].getHandlingPlus());
                vrotspeed = 0.1f * (vehicles[selected_vehicle].getHandling() + vehicles[selected_vehicle].getHandlingPlus());


                if (lives < 1) {
                    Reset();
                }
                gl.glFrustumf(0, Screen_Width, 0, Screen_Height - 200, -100, 100);
                //Decide on where gold spawn


                if (pz < (vz - 10f)) {
                    //pz=vz+100f;

                    powerupNumber = (int) Math.ceil(4d * Math.random());
                    pz = vz + powerUpFrequency - 1000f * ((float) (vehicles[selected_vehicle].getLuck() + vehicles[selected_vehicle].getLuckPlus())) / 10f;
                    px = (float) Math.random() * CV.WidthOfLevels * 0.8f - CV.WidthOfLevels * 0.8f / 2f;
                    py = (float) Math.random() * CV.HeightOfLevels * 0.8f - CV.HeightOfLevels * 0.8f / 2f;

                }

                if (vz > (lastGoldSpawnPoint - 1000f)) {
                    spawnnum = (int) (Math.random() * 12d);
                    float chosenx = (float) Math.random() * CV.WidthOfLevels * 0.8f - CV.WidthOfLevels * 0.8f / 2f;
                    float choseny = (float) Math.random() * CV.HeightOfLevels * 0.8f - CV.HeightOfLevels * 0.8f / 2f;


                    if (Math.random() > 0.2) {
                        skipped = true;
                    }
                    for (c = 0; c < spawnnum; c++) {

                        goldx[(c + goldSpawnNum) % (gold_object.length)] = chosenx;

                        if (skipped) {
                            goldx[(c + goldSpawnNum) % (gold_object.length)] = goldx[(c + goldSpawnNum) % (gold_object.length)] = 10000f;
                        }
                        goldy[(c + goldSpawnNum) % (gold_object.length)] = choseny;
                        goldz[(c + goldSpawnNum) % (gold_object.length)] = lastGoldSpawnPoint + (float) c * 3f * 1f;


                        float randNum = (float) Math.random();

                        if (randNum <= (1 - PLATINUMAbundance - DIAMONDAbundance)) {
                            goldValue[(c + goldSpawnNum) % (gold_object.length)] = 1;
                        }
                        if (randNum > (1 - PLATINUMAbundance - DIAMONDAbundance) && randNum <= (1 - PLATINUMAbundance)) {
                            goldValue[(c + goldSpawnNum) % (gold_object.length)] = 2;
                        }
                        if (randNum > (1 - PLATINUMAbundance) && randNum <= (1)) {
                            goldValue[(c + goldSpawnNum) % (gold_object.length)] = 3;
                        }

                        lastGoldSpawnPoint = goldz[(c + goldSpawnNum) % (gold_object.length)];


                    }

                    skipped = false;
                    //else{
                    //	lastGoldSpawnPoint=goldz[goldSpawnNum]+(float)spawnnum*3;
                    //}
                    goldSpawnNum = goldSpawnNum + spawnnum;

                }


                //Decide when rockets + BOD spawn


                if (vz > (rocketspawnlength) * rocketspawnnum) {

                    spawnnum = (int) (rocketspawnnum * (float) Math.random() * 1.3f) + 1;

                    if (spawnnum > rocket.length) {
                        spawnnum = rocket.length;

                    }
                    for (c = 0; c < spawnnum; c++) {
                        rocketWantSpawned[c] = true;
                    }
                    rocketspawnnum++;
                }

                if (vz > (((BODspawnlength) * BODspawnnum) + 2000f)) {
                    spawnnum = (int) (2 + BODspawnnum * (float) Math.random() * 1);
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
                gl.glLoadIdentity();
                gl.glFrustumf(-xaxis, xaxis, -yaxis, yaxis, 0, 0);


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


                gl.glPushMatrix();
                {
                    gl.glColor4f(0.2f, 0.2f, 0.2f, 1f);
                    gl.glTranslatef(vx, vy + cameraheight, vz - cameradiatancebehind + 0.005f);
                    //glRotatef(cam.getRX(),cam.getX()-10,0,0);
                    //	glRotatef(-cam.getRY(),0,-cam.getY()-10,0);
	    	    	/*
	    	    	 * Problem code here
	    	    	 */

                    //glRotatef(cam.getRZ(),0,0,cam.getZ()-10);

                    //Top GUI
                    rC.drawWithBuffers(gl, getmGUItopper(), getmStandardRectInd(), 4);


                /*gl.glPushMatrix();{


                    gl.glTranslatef(0, 0, -0.000001f);
                    glBegin(GL_QUADS);{
                        gl.glColor4f(0.2f, 0.8f, 0.3f, 1f);

    				//glVertex2f( -xaxis*0.95f ,yaxis*.65f);
    				//glVertex2f( -xaxis*0.95f ,yaxis*0.95f);
    				//glVertex2f( -xaxis*0.90f ,yaxis*0.95f);
    				//glVertex2f(- xaxis*0.90f ,yaxis*.65f);

    				//glVertex2f( -xaxis*0.85f ,yaxis*.65f);
    				//glVertex2f( -xaxis*0.85f ,yaxis*0.95f);
    				//glVertex2f( -xaxis*0.80f ,yaxis*0.95f);
    				//glVertex2f( -xaxis*0.80f ,yaxis*.65f);

                        glVertex2f( -xaxis*0.95f ,yaxis*.65f);
                        glVertex2f( -xaxis*0.95f ,yaxis*0.95f);
                        glVertex2f( -xaxis*0.90f ,yaxis*0.95f);
                        glVertex2f(- xaxis*0.90f ,yaxis*.65f);

                        glVertex2f( -xaxis*0.85f ,yaxis*.65f);
                        glVertex2f( -xaxis*0.85f ,yaxis*0.95f);
                        glVertex2f( -xaxis*0.80f ,yaxis*0.95f);
                        glVertex2f( -xaxis*0.80f ,yaxis*.65f);
                    }glEnd();

                    glBegin(GL_LINE_LOOP);{
                        glVertex2f( -xaxis*0.9993f ,yaxis*.6f);
                        glVertex2f( -xaxis*0.9993f ,yaxis*0.988f);
                        glVertex2f( -xaxis*0.7499f ,yaxis*0.988f);
                        glVertex2f( -xaxis*0.7499f ,yaxis*.6f);

                    }glEnd();

                }
                gl.glPopMatrix();
            */
                }

                gl.glPopMatrix();


                gl.glPushMatrix();
                {


                    gl.glTranslatef(vx + xaxis * 0.72f, vy + cameraheight - yaxis * 0.62f, vz - cameradiatancebehind + 0.004f);


                    gl.glPushMatrix();
                    {
                        gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
                        rC.drawWithBuffers(gl, getmGUIBigCircleVerts(), getmGUICircleInd(), 21);
                    }
                    gl.glPopMatrix();
                    gl.glPushMatrix();
                    {
                        gl.glTranslatef(magcounterx / -16f, magcountery / 16f, -0.00001f);
                        gl.glColor4f(0.8f, 0.3f, 0.2f, 1);
                        rC.drawWithBuffers(gl, getmGUILittleCircleVerts(), getmGUICircleInd(), 21);
                    }
                /*

                glBegin(GL_TRIANGLES);{
                    float radius=0.15f;
                    float xvector;
                    float prevxvector=0f;
                    float yvector;
                    float prevyvector=0f;

                    int stacks=100;


                    for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                        gl.glColor4f(0.5f, 0.4f, 0.5f, 1f);
                        glVertex2f(0,0);
                        xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                        yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
                        //System.out.println(" fafsddf   " +xvector+"   "+yvector);

                        gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
                        glVertex2f(prevxvector,prevyvector);
                        glVertex2f(xvector,yvector);
                        prevxvector=xvector;
                        prevyvector=yvector;

                    }

                    prevxvector=0f;
                    prevyvector=0f;

                    for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                        gl.glColor4f(0.5f, 0.4f, 0.5f, 1f);
                        glVertex2f(0, 0);
                        xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                        yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
                        //System.out.println(" fafsddf   " +xvector+"   "+yvector);

                        gl.glColor4f(0.5f, 0.5f, 0.5f, 1f);
                        glVertex2f(prevxvector, -prevyvector);
                        glVertex2f(xvector, -yvector);
                        prevxvector=xvector;
                        prevyvector=yvector;
                    }

                }glEnd();
                */


                /*
                gl.glPushMatrix();{
                    gl.glTranslatef(magcounterx / -16f, magcountery / 16f, -0.00001f);
                    gl.glColor4f(0.8f, 0.3f, 0.2f, 1);
                    glBegin(GL_TRIANGLES);{
                        float radius=0.05f;
                        float xvector;
                        float prevxvector=0f;
                        float yvector;
                        float prevyvector=0f;

                        int stacks=100;


                        for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                            glVertex2f(0,0);
                            xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                            yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
                            //System.out.println(" fafsddf   " +xvector+"   "+yvector);


                            glVertex2f(prevxvector,prevyvector);
                            glVertex2f(xvector,yvector);
                            prevxvector=xvector;
                            prevyvector=yvector;

                        }

                        prevxvector=0f;
                        prevyvector=0f;

                        for(int ccounter=0;ccounter<(stacks+1);ccounter++){
                            glVertex2f(0,0);
                            xvector=(float)(((float)ccounter -(float)stacks/2f)/(float)stacks)*radius*2f;
                            yvector= (float)Math.sqrt((double)(radius*radius-xvector*xvector));
                            //	System.out.println(" fafsddf   " +xvector+"   "+yvector);


                            glVertex2f(prevxvector,-prevyvector);
                            glVertex2f(xvector,-yvector);
                            prevxvector=xvector;
                            prevyvector=yvector;
                        }

                    }glEnd();
                }
                gl.glPopMatrix();

               */

                }
                gl.glPopMatrix();


                //glOrtho(0,Display.getWidth(),0,Display.getHeight(), -100,100);

                //cam.useView(CameraX,CameraY,-CameraZ,CameraRX);

                gl.glClearColor(0, 0, 0, 0.8f);

                //if(-h%ColourChangeInterval>ColourChangeInterval/2){glClearColor(1,0,0,1);}else{glClearColor(0,1,0,1);}
                if (mouseDown) {

                    if (Screen_Width / 100 * 87.5 < mx && Screen_Width > mx) {
                        if (Screen_Height / 100 * 80 < my && Screen_Height > my) {
                            pauseMenuActivated = true;
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

                        RX[c] = (float) Math.random() * CV.WidthOfLevels - CV.WidthOfLevels / 2;
                        RY[c] = (float) Math.random() * CV.HeightOfLevels - CV.HeightOfLevels / 2;
                        RZ[c] = vz + 1200 + (float) Math.random() * 2000;
                    }

                    rock[c] = new Rock(gl, RX[c], RY[c], RZ[c]);


                    //	System.out.println("RZ[ "+ c +"] : "+RZ[c]);
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
                if (mouseDown) {


                    magcounterx = ((float) mx - (float) Screen_Width * 0.14f) / 40f;
                    magcountery = ((float) my - (float) Screen_Height * 0.19f) / 40f;


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
                    ///    		,(double)(xrot/rotlimit));
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

                   /*

    				if (xrot>rotlimit/2f){

    					vrotspeed=default_x_vrotspeed*2f;

                    }
        			else if (xrot<-rotlimit/2f){

        				vrotspeed=default_x_vrotspeed*2f;

                    }else{
                    	//vrotspeed=default_x_vrotspeed/1.5f;
                    	vrotspeed=0.05f*(vehicles[selected_vehicle].getHandling()+vehicles[selected_vehicle].getHandlingPlus());

                    }


    				xrot =xrot-magcounterx*vrotspeed;




        			if (yrot>rotlimit/2f){

        				vrotspeed=default_y_vrotspeed*2f;

                    }
        			else if (yrot<-rotlimit/2f){

        				vrotspeed=default_y_vrotspeed*2f;
                    }else{
                    	//vrotspeed=default_y_vrotspeed/1.5f;
                    	vrotspeed=0.05f*(vehicles[selected_vehicle].getHandling()+vehicles[selected_vehicle].getHandlingPlus());

                    }

                    *yrot =yrot+magcountery*vrotspeed;
                    */

                    xrot = xrot - magcounterx * vrotspeed;
                    yrot = yrot + magcountery * vrotspeed;


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


                //	glPushMatrix();{glColor3f(0.5f,0.5f,1);  glTranslatef(5,5,-1+h*3);glBegin(GL_QUADS);{ glVertex3f(+0,+0,-10);glVertex3f(+1,+0,-10); glVertex3f(+0,+1,-10);glVertex3f(+1,+1,-10);glVertex3f(+0,+0,-11);glVertex3f(+1,+0,-11); glVertex3f(+0,+1,-11);glVertex3f(+1,+1,-11); glVertex3f(+1,+0,-10);glVertex3f(+1,+1,-10); glVertex3f(+1,+0,-11);glVertex3f(+1,+1,-11); glVertex3f(+0,+0,-10);glVertex3f(+0,+1,-10); glVertex3f(+0,+0,-11);glVertex3f(+0,+1,-11);glVertex3f(+0,+0,-10);glVertex3f(+1,+0,-10);glVertex3f(+0,+0,-11);glVertex3f(+1,+0,-11);glVertex3f(+0,+0,-10);glVertex3f(+1,+1,-10); glVertex3f(+0,+0,-11);glVertex3f(+1,+1,-11); }glEnd();}glPopMatrix();

                //Meteor met=new Meteor(vz+40);

                Wall_plain w1 = new Wall_plain(gl,z1, false);
                Wall_plain w2 = new Wall_plain(gl,z1, true);
                Wall_plain w3 = new Wall_plain(gl,z2, false);
                Wall_plain w4 = new Wall_plain(gl,z2, true);
                Wall_plain w5 = new Wall_plain(gl,z3, false);
                Wall_plain w6 = new Wall_plain(gl,z3, true);

                Ceiling_plain c1 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z1, false);
                Ceiling_plain c2 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z2, false);
                Ceiling_plain c3 = new Ceiling_plain(gl,-CV.HeightOfLevels / 2, z3, false);
                if ((vz > (z1 + CV.LengthOfLevels))) {
                    z1 = z1 + CV.LengthOfLevels;
                    z2 = z2 + CV.LengthOfLevels;
                    z3 = z3 + CV.LengthOfLevels;
                    WallsNeedReseting = false;
                }
                //  Display.update();
                //Visibles
                //TC=new The_Cube(vx,vy,vz,xrot,yrot,zrot);
                // 	vehicles[selected_vehicle]=new ElectricRing(vx,vy,vz,xrot,yrot,zrot);
                vehicles[selected_vehicle].Render(vx, vy, vz, xrot, yrot, zrot);
                //	ER=new ElectricRing(vx,vy,vz,xrot,yrot,zrot);
                //motor=new Motor(vx,vy,vz,xrot,yrot,zrot);
                //SpaceShuttle SS=new SpaceShuttle(vx,vy,vz,xrot,yrot,zrot);
                PowerUps power = new PowerUps(gl,px, py, pz, powerupNumber + 3);
                //for (c=0;c<power.length;c++){
                if (co.Collide_vertices_gold(vehicles[selected_vehicle], power)) {
                    px = px + 1000f - frequencyUpgradeNumber * distanceDecreasedPerExtraFrequencyNumber;
                    if (power.getValue() == 4) {
                        goldThisTurn = goldThisTurn + coinsFromChest + ChestUpgradeNumber * extraCoinsFromChestUpgradeNumber;
                        numberOfPowerUps++;

                    }
                    if (power.getValue() == 5) {
                        collisionsOn = false;
                        effectCanCancel = true;
                        framesUntilNormal = framesUntilNormalSpeedy + SpeedyUpgradeNumber * extraFramesUntilNormalSpeedyUpgradeNumber;
                        numberOfPowerUps++;

                    }
                    if (power.getValue() == 6) {
                        collisionsOn = false;
                        effectCanCancel = false;
                        framesUntilNormal = framesUntilNormalInvincibility + InvincibilityUpgradeNumber * extraFramesUntilNormalInvincibilityUpgradeNumber;
                        powerUpSpeedOn = true;
                        numberOfPowerUps++;
                    }
                    if (power.getValue() == 7) {
                        collisionsOn = true;
                        effectCanCancel = false;
                        framesUntilNormal2 = MagnetUpgradeNumber * extraFramesUntilNormalMagnetUpgradeNumber;
                        co.setExtendedAttraction(100f);
                        numberOfPowerUps++;
                    }

                }
                //}


                for (c = 0; c < gold_object.length; c++) {

                    gold_object[c] = new Gold(gl, goldx[c], goldy[c], goldz[c], goldValue[c]);
                    //	if (co.CollideForGold(TC, gold_object[c])){}
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
                //Ball of Death Code

                for (c = 0; c < BOD.length; c++) {
                    BOD[c] = new BallOfDeath(gl, BODx[c], BODy[c], BODz[c]);
                    BODx[c] = BODx[c] + BODvx[c];
                    BODy[c] = BODy[c] + BODvy[c];
                    BODz[c] = BODz[c] + BODvz[c];


                    if (BODx[c] > CV.WidthOfLevels / 2f - 4f) {
                        BODvx[c] = (float) Math.abs((double) BODvx[c]) * -1f;
                        if (BODx[c] > CV.WidthOfLevels / 2f) {
                            //destruct
                        }
                    }
                    if (BODx[c] < -CV.WidthOfLevels / 2f + 4f) {
                        BODvx[c] = (float) Math.abs((double) BODvx[c]) * 1f;
                        if (BODx[c] > CV.WidthOfLevels / 2f) {
                            //destruct
                        }
                    }
                    if (BODy[c] > CV.HeightOfLevels / 2f - 4f) {
                        BODvy[c] = BODvy[c] - 0.2f;
                        if (BODy[c] > CV.HeightOfLevels / 2f - 4f) {
                            //destruct
                        }
                    }

                    if (BODy[c] < -CV.HeightOfLevels / 2 + 4f) {
                        BODvy[c] = (float) Math.abs((double) BODvy[c]) * 1f;
                        if (BODy[c] > CV.HeightOfLevels / 2f - 4f) {
                            //destruct
                        }
                    }

                    // if(BODinAttackMode[c]){ System.out.println(BODvz[c]); BODvz[c]=BODvz[c]-0.00000005f; }
                    if (vz > 0) {


                        //System.out.println(BODx[c]+"    "+BODy[c]+"      "+BODz[c]);
                        inAttackMode[c] = true;


                        if (BODWantSpawned[c]) {
                            // BODvx[c]=(float)Math.random()*2f-1f;
                            // BODvy[c]=(float)Math.random()*2f-1f;
                            float[] Coords = new float[3];
                            // System.out.println(BODx[c]+"1    "+BODy[c]+"      "+BODz[c]);
                            Coords = SpawnRockets();
                            // System.out.println(BODx[c]+"2    "+BODy[c]+"      "+BODz[c]);
                            BODx[c] = Coords[0];
                            BODy[c] = Coords[1];
                            BODz[c] = Coords[2];
                            //System.out.println(BODx[c]+"3    "+BODy[c]+"      "+BODz[c]);

                            BODWantSpawned[c] = false;

                        }
                    }


                }


                //rocket

                for (c = 0; c < rocket.length; c++) {
                    rocket[c] = new Rocket(gl, rocketx[c], rockety[c], rocketz[c]);
                    rocketx[c] = rocketx[c] + rocketvx[c];
                    rockety[c] = rockety[c] + rocketvy[c];
                    rocketz[c] = rocketz[c] + rocketvz[c];
                    if ((vx > rocketx[c]) || (vx < rocketx[c])) {

                        rocketvx[c] = rocketvx[c] - (rocketx[c] - vx) / 1000f;

                    }
                    if (vy > rockety[c] || vy < rockety[c]) {

                        rocketvy[c] = rocketvy[c] - (rockety[c] - vy) / 1000f;

                    }

                    if (rocketx[c] > CV.WidthOfLevels / 2f - 3f) {
                        rocketvx[c] = (float) Math.abs((double) rocketvx[c]) * -0.4f;
                        rocketx[c] = rocketx[c];
                        if (rocketx[c] > CV.WidthOfLevels / 2f) {
                            //destruct
                        }
                    }
                    if (rocketx[c] < -CV.WidthOfLevels / 2f + 3f) {
                        rocketvx[c] = (float) Math.abs((double) rocketvx[c]) * 0.4f;

                        rocketx[c] = rocketx[c];
                        if (rocketx[c] > CV.WidthOfLevels / 2f) {
                            //destruct
                        }
                    }
                    if (rockety[c] > CV.HeightOfLevels / 2f - 3f) {
                        rocketvy[c] = rocketvy[c] - 0.2f;
                        if (rockety[c] > CV.HeightOfLevels / 2f - 4f) {
                            //destruct
                        }
                    }

                    if (rockety[c] < (-CV.HeightOfLevels / 2 + 4f)) {
                        rocketvy[c] = (float) Math.abs((double) rocketvy[c]) * 0.4f;
                        rockety[c] = rockety[c] + rocketvy[c];
                        if (rockety[c] > CV.HeightOfLevels / 2f - 4f) {
                            //destruct
                        }
                    }

                    if (inAttackMode[c]) {
                        //System.out.println(rocketvz[c]);
                        rocketvz[c] = rocketvz[c] - 0.00000005f;
                    }
                    if (vz > 0) {
                        // System.out.println(rocketx[c]+"    "+rockety[c]+"      "+rocketz[c]);
                        inAttackMode[c] = true;


                        if ((rocketWantSpawned[c]) || (respawneverything[c] == true)) {
                            respawneverything[c] = false;
                            rocketvz[c] = (float) Math.random() * -2f - 5f;
                            float[] Coords = new float[3];
                            System.out.println(rocketx[c] + "1    " + rockety[c] + "      " + rocketz[c]);
                            Coords = SpawnRockets();
                            System.out.println(rocketx[c] + "2    " + rockety[c] + "      " + rocketz[c]);
                            rocketx[c] = Coords[0];
                            rockety[c] = Coords[1];
                            rocketz[c] = Coords[2];
                            // rocketz[c]=-100f;
                            System.out.println(rocketx[c] + "3    " + rockety[c] + "      " + rocketz[c]);

                            rocketWantSpawned[c] = false;

                        }
                    }
                }
				/*
				 * COLLISIONS
				 */
                if (collisionsOn) {
                    if (framesUntilNormal2 < 0) {
                        co.setExtendedAttraction(3f);
                    } else {
                        framesUntilNormal2 = framesUntilNormal2 - 1;

                    }


                    framesUntilNormal = 400 + framesUntilCollisionsNormalPlus;
                    powerUpSpeedOn = false;
                    for (c = 0; c < rock.length; c++) {

                        if (co.Collide_vertices_cube(vehicles[selected_vehicle], rock[c],gl)) {
                            lives = lives - 1;
                            RX[c] = RX[c] + 1000f;
                        }

                    }
                    for (c = 0; c < rocket.length; c++) {

                        if (co.collide_vertices_rocket(vehicles[selected_vehicle], rocket[c])) {
                            lives = lives - 2;
                            rocketx[c] = rocketx[c] + 1000f;
                        }
                    }
                    for (c = 0; c < BOD.length; c++) {

                        if (co.collide_vertices_BOD(vehicles[selected_vehicle], BOD[c])) {
                            lives = lives - 1;
                            BODx[c] = BODx[c] + 1000f;
                        }
                    }

                } else {
                    gl.glPushMatrix();
                    gl.glEnable(GL10.GL_BLEND);
                    gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
                    gl.glColor4f(0.2f, 0.2f, 0.7f, 2f * ((float) framesUntilNormal / 400f));
                    gl.glTranslatef(vx, vy, vz);
                    //Sphere sphere=new Sphere();
                    //sphere.draw(vehicles[selected_vehicle].getLength()/1.5f, 40, 40);

                    gl.glDisable(GL10.GL_BLEND);
                    gl.glPopMatrix();
                    framesUntilNormal = framesUntilNormal - 1;

                    if (effectCanCancel == true) {

                        //	framesUntilNormal=-1;
                    }
                    if (powerUpSpeedOn == true && framesUntilNormal > 50) {

                        vz = vz + 5f;
                    }
                    if (framesUntilNormal < 0) {
                        collisionsOn = true;

                    }


                }

		    	/*
				if (vx>CV.WidthOfLevels/2-6.5f){
					vx=CV.WidthOfLevels/2-6.5f;
					if(xrot>2f){
					xrot=xrot-2f;
					}
				}
				if(vx<-(CV.WidthOfLevels/2-4f)){
					vx=-CV.WidthOfLevels/2+4f;
					if(xrot<-2f){
						xrot=xrot+2f;
						}
				}
				if (vy>CV.HeightOfLevels/2-2f){

                    if(yrot>1f){
                    yrot=yrot-1f;
                    }

                    }
				if (vy<-(CV.HeightOfLevels/2-0.8f)){
				    vy=-CV.HeightOfLevels/2+0.8f;
				    if(yrot<-2f){
	                yrot=yrot+2f;
				    }
				}
				*/


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


                accelerationz = accelerationz * 0.9980f;
                velocityz = velocityz + accelerationz;
                vz = vz + velocityz;
                score = vz / 10 + goldThisTurn * 5;
                //long endTime = getTime();
                //if (endTime - startTime == 0) {
                //} else {
                //    fps = (1000 / (endTime - startTime));
                //}
                fps=84394389;
                //counter++;


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


                gl.glMatrixMode(GLES10.GL_MODELVIEW);
                //Display.update();
                gl.glClear(GLES10.GL_COLOR_BUFFER_BIT);
                gl.glClear(GLES10.GL_DEPTH_BUFFER_BIT);
                gl.glEnable(GLES10.GL_DEPTH_TEST);
                gl.glDisable(GLES10.GL_BLEND);
                gl.glEnable(GLES10.GL_TEXTURE_2D);

                mouseDown = false;


            }






            if (pauseMenuActivated==true){
                gl.glLoadIdentity();
                gl.glPushMatrix();

                int textureID=R.drawable.pausemenuhighdef;

                gl.glEnable(GL10.GL_TEXTURE);
                gl.glColor4f(1f, 1f, 1f, 1f);
                gl.glTranslatef(0, 0, 0);
                rC.drawWithBuffers(gl, this.getmStandardRectVerts(), this.getmStandardRectUVCoordsVerts(), this.getmStandardRectInd(), 6, textureID);

                gl.glDisable(GL10.GL_TEXTURE);
                gl.glPopMatrix();
                r++;

                //Display.update();/////////////////////////////////////////////////


                gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
                gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);
                gl.glEnable(GL10.GL_DEPTH_TEST);
                if (mouseDown){
                    if(menuoption==0){

                        if ((float)Screen_Width/512f*160f<mx&&mx<(float)Screen_Width/512f*350f){
                            //Resume
                            if ((float)(Screen_Height)/512f*352f<my&&my<(float)Screen_Height/512f*412f){

                                pauseMenuActivated=false;

                            }

                            if ((float)(Screen_Height)/512f*262f<my&&my<(float)Screen_Height/512f*322f){


                            }


                            if ((float)(Screen_Height)/512f*80f<my&&my<(float)Screen_Height/512f*140f){
                                option=0;
                                Reset();
                                pauseMenuActivated=false;
                            }

                        }
                    }
                }


            }
        }







    }

//private static long getTime() {
    //return (Sys.getTime()*1000)/Sys.getTimerResolution();
    // }

    public static void testMissions(){

        for (int h=0;h<selectedMission.length;h++) {
            int level = missionProgress[selectedMission[h]];
            Boolean missionPassed = false;
            switch (selectedMission[h]) {

                case 0:
                    if (vz >= 1500 + level * 500) {
                        missionPassed = true;
                    }
                    break;
                case 1:
                    if (score >= 1000 + level * 1000) {
                        missionPassed = true;
                    }
                    break;
                case 2:
                    if (goldThisTurn >= 50 + level * 50) {
                        missionPassed = true;
                    }
                    break;

                case 3:
                    if (numberOfPowerUps >= 3 + level) {
                        missionPassed = true;
                    }
                    break;
                case 4:
                    if (vzBeforeFirstPowerUp >= 1000 + level * 400) {
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
                } else {
                    completedMission[0] = selectedMission[h];
                }


                gold = gold + 250 * (level + 1);
                selectedMission[h] = 99;

            }

        }}










    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Screen_Height=height;
        Screen_Width=width;
        gl.glViewport(0, 0, width, height);
        float aspect = (float)width / height;
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 1.0f, 10.0f);
    }
    /*
        private void setAllBuffers(){
            // Set vertex buffer
            float vertexlist[] = {
                    -1.0f, 0.0f, -1.0f,  1.0f, 0.0f, -1.0f,  -1.0f, 0.0f, 1.0f,
                    1.0f, 0.0f, 1.0f,  0.0f, 2.0f, 0.0f,
            };
            ByteBuffer vbb = ByteBuffer.allocateDirect(vertexlist.length * 4);
            vbb.order(ByteOrder.nativeOrder());
            setmVertexBuffer(vbb.asFloatBuffer());
            getmVertexBuffer().put(vertexlist);
            getmVertexBuffer().position(0);

            // Set triangle border buffer with vertex indices
            short trigborderindexlist[] = {
                    4, 0,  4, 1,  4, 2,  4, 3,  0, 1,  1, 3,  3, 2,  2, 0,  0, 3
            };
            setmNumOfTriangleBorderIndices(trigborderindexlist.length);
            ByteBuffer tbibb = ByteBuffer.allocateDirect(trigborderindexlist.length * 2);
            tbibb.order(ByteOrder.nativeOrder());
            setmTriangleBorderIndicesBuffer(tbibb.asShortBuffer());
            getmTriangleBorderIndicesBuffer().put(trigborderindexlist);
            getmTriangleBorderIndicesBuffer().position(0);
        }*/
    public static int pickNewMission(int whichSelectedMission){


        selectedMission[whichSelectedMission]=(int)(Math.random()*(missionProgress.length-1));
        if (selectedMission[whichSelectedMission]==selectedMission[(whichSelectedMission+1)%3]||selectedMission[whichSelectedMission]==selectedMission[(whichSelectedMission+2)%3])
        {

            selectedMission[whichSelectedMission]=pickNewMission(whichSelectedMission);
        }
        return selectedMission[whichSelectedMission];
    }
    public static void Reset() {

        testMissions();


        for (int g = 0; g < selectedMission.length; g++) {
            if (selectedMission[g] == 99) {
                selectedMission[g] = pickNewMission(g);
            }
        }


        framesUntilNormal = 0;
        framesUntilNormal2 = 0;
        goldThisTurn = goldThisTurn + (int) vz / 100;
        gold = gold + goldThisTurn;
        long variabledfkdfop = (long) gold;


        System.out.println("y       " + getGold());


        float f = getGold();

        try {
            goldFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/goldValue.txt", false)));
            goldFileWriter.write(Float.toString(f));

            goldFileWriter.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        System.out.println("y       " + f);


        ((Menus) menus).setNotDone000(true);
        for (int c = 0; c < respawneverything.length; c++) {
            respawneverything[c] = true;
        }
        z1 = 0f;
        goldSpawnNum = 0;
        lastGoldSpawnPoint = -100f;
        BODspawnnum = 0f;
        rocketspawnnum = 0f;
        z2 = LengthOfLevels;
        z3 = LengthOfLevels * 2;
        WallsNeedReseting = true;
        //  int b=(int)(vehicles[0].getSizePlus())*10;
        //   int n;
        //  int m;
        int[] upgrades =
                {
                        frequencyUpgradeNumber,
                        SpeedyUpgradeNumber,
                        InvincibilityUpgradeNumber,
                        MagnetUpgradeNumber,
                        ChestUpgradeNumber,
                        (int) vehicles[0].getHandlingPlus(),
                        (int) vehicles[0].getLuckPlus(),
                        (int) (vehicles[0].getSizePlus()),
                        (int) vehicles[0].getArmourPlus(),
                        (int) vehicles[1].getHandlingPlus(),
                        (int) vehicles[1].getLuckPlus(),
                        (int) (vehicles[1].getSizePlus()),
                        (int) vehicles[1].getArmourPlus(),
                        (int) vehicles[2].getHandlingPlus(),
                        (int) vehicles[2].getLuckPlus(),
                        (int) (vehicles[2].getSizePlus()),
                        (int) vehicles[2].getArmourPlus(),
                        (int) vehicles[0].getBought(),
                        (int) (vehicles[1].getBought()),
                        (int) vehicles[2].getBought(),
                        (int) missionProgress[0],
                        (int) missionProgress[1],
                        (int) missionProgress[2],
                        (int) missionProgress[3],
                        (int) missionProgress[4],
                        (int) selectedMission[0],
                        (int) selectedMission[1],
                        (int) selectedMission[2]
                };

        try {
            upgradesFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/upgrades.txt")));

            for (int c = 0; c < upgrades.length; c++) {
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


        for (int c = 0; c < RX.length; c++) {
            RX[c] = (float) Math.random() * WidthOfLevels - WidthOfLevels / 2;
            RY[c] = (float) Math.random() * HeightOfLevels - HeightOfLevels / 2;
            RZ[c] = -vz + 250 + 30 * c + ((float) Math.random()) * 100;


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

        Arrays.sort(highScores);
        if (score > highScores[0]) {
            highScores[0] = score;
            Arrays.sort(highScores);
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

        try {
            lastRunFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/lastRun.txt")));


            try {
                //vz, gold, score, numberOfPowerUps
                lastRunFileWriter.write((int) vz / 10 + "  \n" + (int) (goldThisTurn - vz / 100) + "  \n" + (int) score + "  \n" + (int) numberOfPowerUps + "  \n");

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
        goldThisTurn = 0;
        vx = 0;
        vy = 0;
        vz = 0;
        score = 0;
        numberOfPowerUps = 0;
        xrot = 0;
        yrot = 0;
        zrot = 0;
        velocityz = 2f;
        accelerationz = 0.01f;
        option = 0;
        lastMark = 0;
        nextMark = 2500f;
        menuoption = 99;
    }

    public static void ResetMenu(){
        framesUntilNormal=0;
        framesUntilNormal2=0;
        goldThisTurn=goldThisTurn+(int)vz/100;
        gold=gold+goldThisTurn;
        long variabledfkdfop=(long) gold;

        goldThisTurn=0;


        float f=getGold();

        try {
            goldFileWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mContext.getFilesDir()+"/goldValue.txt",false)));
            goldFileWriter.write(Float.toString(f));

            goldFileWriter.close();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }





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
                        (int)missionProgress[0],
                        (int)missionProgress[1],
                        (int)missionProgress[2],
                        (int)missionProgress[3],
                        (int)missionProgress[4],
                        (int)selectedMission[0],
                        (int)selectedMission[1],
                        (int)selectedMission[2]
                };

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

    public static void CleanUp(){
        try {
            //scoreFileWriter.flush();
            scoreFileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        // Display.destroy();
    }
    /*public static Texture LoadTexture(String Key){
        try {
            return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+Key+".png")));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    */
    /*
    public static Texture LoadFont(String Key){
        try {
            return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+Key+".png")));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public static float getRealX(float originalX,float originalY, float originalZ, float rotationPointX, float rotationPointY, float rotationPointZ,float rotatePointDegree)
    {
        float magnnitude=(float)Math.sqrt((float) (Math.sqrt((originalX-rotationPointX)*(originalX-rotationPointX)+(originalY-rotationPointY)*(originalY-rotationPointY)))+(originalZ-rotationPointZ)*(originalZ-rotationPointZ));
        float RealX=originalX-rotationPointX;
        return RealX;
    }
    */
    public static float[] SpawnRockets(){

        float[] Coords=new float[3];

        Coords[0]=((float)Math.random()*WidthOfLevels*0.9f-WidthOfLevels/2f);
        Coords[1]=((float)Math.random()*HeightOfLevels*0.9f-HeightOfLevels/2f);
        Coords[2]=(float)Math.random()*800f+1200f+vz;

        return Coords;
    }
    public static void fjkf(int textureName){
        /*gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);      //  kinda  irrelevant
        gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);	         //  kinda  irrelevant
        mTextureList=new int[1];


        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl.glGenTextures(1, mTextureList, 0);
        gl.glClientActiveTexture(GL10.GL_TEXTURE0);*/
        Bitmap b = BitmapFactory.decodeResource(mContext.getResources(), textureName);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, b, 0);



    }
}

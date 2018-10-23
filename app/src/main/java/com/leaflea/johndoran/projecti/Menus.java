package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;


public class Menus   {


    public static Boolean getNotDone000() {
        return notDone000;
    }

    public static void setNotDone000(Boolean notDone000) {
        Menus.notDone000 = notDone000;
    }

    public static float getHeightOfTags() {
        return heightOfTags;
    }

    public static void setHeightOfTags(float heightOfTags) {
        Menus.heightOfTags = heightOfTags;
    }

    public static float getDistanceBetweenTags() {
        return distanceBetweenTags;
    }

    public static void setDistanceBetweenTags(float distanceBetweenTags) {
        Menus.distanceBetweenTags = distanceBetweenTags;
    }

    public static float getDistanceFromTopToTop() {
        return distanceFromTopToTop;
    }

    public static void setDistanceFromTopToTop(float distanceFromTopToTop) {
        Menus.distanceFromTopToTop = distanceFromTopToTop;
    }




    //public static  float xaxis=0.62f;
    //public static float yaxis=0.47f;
    private static Boolean notDone000=true;
    public static float aspect;
    public static  float xaxis=1f;
    public static float yaxis=1f;

    public static float sizeOfStatRects=0.06f;
    public static float distanceOfStatRects=0.06f;

    public static float heightOfTags=80f;
    public static float distanceBetweenTags=20f;
    public static float distanceFromTopToTop=heightOfTags+distanceBetweenTags;

    public static float[] tagVerts;
    public static float[] smallRects;
    public static float[] midSizeRect;
    public static float[] smallIconVerts;

    MyRenderer MR;

    renderController rC=new renderController();

    Boolean undeclared=true;
    //static Texture huh= LoadTexture("walls_plain-highdef");

    GL10 gl;
    public Menus(GL10 gl) {

        this.gl=gl;

        this.MR=rC.getMR();
        aspect=MR.getAspect();
        xaxis=aspect;
        yaxis=1f;

    }

    public static float[] getTagVerts() {
        return tagVerts;
    }

    public static void setTagVerts(float[] tagVerts) {
        Menus.tagVerts = tagVerts;
    }

    public static float[] getSmallRects() {
        return smallRects;
    }

    public static void setSmallRects(float[] smallRects) {
        Menus.smallRects = smallRects;
    }

    public static float[] getMidSizeRect() {
        return midSizeRect;
    }

    public static void setMidSizeRect(float[] midSizeRect) {
        Menus.midSizeRect = midSizeRect;
    }

    public static float[] getSmallIconVerts() {
        return smallIconVerts;
    }

    public static void setSmallIconVerts(float[] smallIconVerts) {
        Menus.smallIconVerts = smallIconVerts;
    }


    public void makeAllVerts(){
        float[] mTagVerts={

                0                   ,-yaxis*2f*(0)/512f,0,
                0                   ,-yaxis*2f*(heightOfTags)/512f,0,
                xaxis*320f/512f     ,-yaxis*2f*(heightOfTags)/512f,0,
                xaxis*320f/512f     ,-yaxis*2f*(0)/512f,0

        };
        setTagVerts(mTagVerts);

        float[] mSmallRects={
                -xaxis*sizeOfStatRects/2f  ,  yaxis*sizeOfStatRects, 0 ,
                -xaxis*sizeOfStatRects/2f  , -yaxis*sizeOfStatRects, 0 ,
                xaxis*sizeOfStatRects/2f  , -yaxis*sizeOfStatRects, 0 ,
                xaxis*sizeOfStatRects/2f  ,  yaxis*sizeOfStatRects, 0
        };
        setSmallRects(mSmallRects);

        float[] mMidRects={
                xaxis*0.00f,yaxis*0.25f,0,
                xaxis*0.00f,yaxis*0.00f,0,
                xaxis*0.25f,yaxis*0.00f,0,
                xaxis*0.25f,yaxis*0.25f,0

        };
        setMidSizeRect(mMidRects);

        float[] mIconRects={
                xaxis*0.00f,yaxis*0.25f,0,
                xaxis*0.00f,yaxis*0.00f,0,
                xaxis*0.25f,yaxis*0.00f,0,
                xaxis*0.25f,yaxis*0.25f,0
        };
        setSmallIconVerts(mIconRects);
    }

    public void MainMenu(){

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, 0);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.wallsplainhighdef);

    }

    public void AboutUs(){

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, 0);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.aboutushighdef);

    }

    public void Custom(){

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, 0);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.custommenuhighdef);

    }

    public void HighScores(){

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, 0);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.highscoresmenuhighdef);

    }
    public void THEME_OVERVIEW_MENU(FontClass font,int chosen) {


        gl.glPushMatrix();

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, -0.0001f);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.thememenuhighdef);


        gl.glPopMatrix();


        float c = 0;
        float heightOfTags = 80f;
        float distanceBetweenTags = 20f;
        float distanceFromTopToTop = heightOfTags + distanceBetweenTags-10f;
        gl.glPushMatrix();

        gl.glTranslatef(0, 0, -0.0000001f);

        int textureID = 0;
        //the cube
        gl.glPushMatrix();
        {
            gl.glTranslatef(-xaxis + 2f * xaxis * 60f / 512f, yaxis - 2f * yaxis * (150f + c * distanceFromTopToTop) / 512f, 0f);
            textureID = R.drawable.tick;
            if (chosen == 0) {
                gl.glColor4f(0f, 1f, 0f, 1f);

            } else {
                gl.glColor4f(1f, 1f, 1f, 1f);

            }

            rC.drawWithBuffers(gl, MR.getmMidRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, textureID);

        }
        gl.glPopMatrix();

        c++;

        //motor nametag
        gl.glPushMatrix();
        {
            gl.glTranslatef(-xaxis + 2f * xaxis * 60f / 512f, yaxis - 2f * yaxis * (150f + c * distanceFromTopToTop) / 512f, 0f);
            if (Theme.getPPbought()) {
                textureID = R.drawable.tick;
            } else {
                textureID = R.drawable.lock;
            }


            if (chosen == 1) {
                gl.glColor4f(0f, 1f, 0f, 1f);

            } else {
                gl.glColor4f(1f, 1f, 1f, 1f);

            }
            rC.drawWithBuffers(gl, MR.getmMidRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, textureID);
        }
        gl.glPopMatrix();

        c++;




        gl.glDisable(GL10.GL_TEXTURE);
        gl.glPopMatrix();



    }

    public void StoreMenu(FontClass font,int chosen) {


        gl.glPushMatrix();

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, -0.0001f);
        if(chosen==0) {
            rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.storemenuonehighdef);
        }else{
            rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.storemenutwohighdef);

        }

        gl.glPopMatrix();


        float heightOfTags = 70f;
        float distanceBetweenTags = 10f;
        float distanceFromTopToTop = heightOfTags + distanceBetweenTags;
        gl.glPushMatrix();

        gl.glTranslatef(0, 0, -0.0000001f);

        int textureID = 0;

        int[] mark=new int[8];//0-bought,1-locked,2-top up

        mark[0]=2;
        mark[1]=2;
        mark[2]=2;
        mark[3]=2;
        mark[4]=2;

        if(MR.getFlying_saucer()) {
            mark[5] = 1;
        }else{
            mark[5] = 0;
        }
        if(MR.getPptheme()) {
            mark[6] = 1;
        }else{
            mark[6] = 0;
        }
        if(MR.getNoads()) {
            mark[7] = 1;
        }else{
            mark[7] = 0;
        }




        for(int c=0;c<4;c++) {


            gl.glPushMatrix();
            {
                gl.glTranslatef(-xaxis + 2f * xaxis * 60f / 512f, yaxis - 2f * yaxis * (90f+heightOfTags + c * distanceFromTopToTop) / 512f, 0f);

                if (mark[c+chosen*4]==0) {
                    textureID = R.drawable.lock;
                } else if(mark[c+chosen*4]==1){
                    textureID = R.drawable.tick;
                }else{
                    textureID = R.drawable.up;
                }


                //if (chosen == 1)
                // gl.glColor4f(0f, 1f, 0f, 1f);
                //} else {
                gl.glColor4f(1f, 1f, 1f, 1f);
                //}
                rC.drawWithBuffers(gl, MR.getmMidRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, textureID);
            }
            gl.glPopMatrix();
        }

        if(chosen==0) {
            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 330f) / 512f, yaxis - 2f * yaxis * (512f - 40f) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmIconRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.down);

            gl.glPopMatrix();

        }else{
            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 330f) / 512f, yaxis - 2f * yaxis * (512f - 40f) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmIconRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.up);

            gl.glPopMatrix();
        }


        gl.glDisable(GL10.GL_TEXTURE);
        gl.glPopMatrix();
    }

    public void VEHICLE_OVERVIEW_MENU(int section) {
        gl.glPushMatrix();

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, -0.0001f);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.shipsmenuhighdef);


        gl.glPopMatrix();


        float c = 0;
        float heightOfTags = 80f;
        float distanceBetweenTags = 20f;
        float distanceFromTopToTop = heightOfTags + distanceBetweenTags;
        gl.glPushMatrix();

        gl.glTranslatef(0, 0, -0.0000001f);

        if(section==0){
        //the cube
        gl.glPushMatrix();
        gl.glTranslatef(-xaxis + 2f * xaxis * 70f / 512f, yaxis - 2f * yaxis * (80f + c * distanceFromTopToTop) / 512f, 0f);
        rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.thecubenametag);

        gl.glPopMatrix();

        c++;

        //motor nametag
        gl.glPushMatrix();
        gl.glTranslatef(-xaxis + 2f * xaxis * 70f / 512f, yaxis - 2f * yaxis * (80f + c * distanceFromTopToTop) / 512f, 0f);
        rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.motornametag);

        gl.glPopMatrix();

            /*
            glTexCoord2f(0f,0f);
            glVertex2f(-xaxis+2f*xaxis*70f/512f,yaxis-2f*yaxis*(80f+0+c*distanceFromTopToTop)/512f);
            glTexCoord2f(0f,1f);
            glVertex2f(-xaxis+2f*xaxis*70f/512f,yaxis-2f*yaxis*(80f+heightOfTags+c*distanceFromTopToTop)/512f);
            glTexCoord2f(1f,1f);
            glVertex2f(-xaxis+2f*xaxis*230f/512f,yaxis-2f*yaxis*(80+heightOfTags+c*distanceFromTopToTop)/512f);
            glTexCoord2f(1f,0f);
            glVertex2f(-xaxis+2f*xaxis*230f/512f,yaxis-2f*yaxis*(80+0+c*distanceFromTopToTop)/512f);
            */

        c++;


        gl.glPushMatrix();
        gl.glTranslatef(-xaxis + 2f * xaxis * 70f / 512f, yaxis - 2f * yaxis * (80f + c * distanceFromTopToTop) / 512f, 0f);
        rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.paperplanenametag);

        gl.glPopMatrix();

        c++;
        gl.glPushMatrix();
        gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 210f) / 512f, yaxis - 2f * yaxis * (80f + (c % 3) * distanceFromTopToTop) / 512f, 0f);
        rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.hangglidernametag);

        gl.glPopMatrix();
        c++;
        gl.glPushMatrix();
        gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 210f) / 512f, yaxis - 2f * yaxis * (80f + (c % 3) * distanceFromTopToTop) / 512f, 0f);
        rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.toyairplanenametag);

        gl.glPopMatrix();

        c++;
        gl.glPushMatrix();
        gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 210f) / 512f, yaxis - 2f * yaxis * (80f + (c % 3) * distanceFromTopToTop) / 512f, 0f);
        rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.zepplinnametag);

        gl.glPopMatrix();


            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 330f) / 512f, yaxis - 2f * yaxis * (512f-80f) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmIconRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.down);

            gl.glPopMatrix();
    }else{
            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * 70f / 512f, yaxis - 2f * yaxis * (80f + c * distanceFromTopToTop) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.vintagenametag);

            gl.glPopMatrix();

            c++;

            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * 70f / 512f, yaxis - 2f * yaxis * (80f + c * distanceFromTopToTop) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.warplanenametag);

            gl.glPopMatrix();
            c++;

            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * 70f / 512f, yaxis - 2f * yaxis * (80f + c * distanceFromTopToTop) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.passengerplanenametag);

            gl.glPopMatrix();

            c++;
            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 210f) / 512f, yaxis - 2f * yaxis * (80f + (c % 3) * distanceFromTopToTop) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.spaceshuttlenametag);

            gl.glPopMatrix();
            c++;
            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 210f) / 512f, yaxis - 2f * yaxis * (80f + (c % 3) * distanceFromTopToTop) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.flyingsaucernametag);

            gl.glPopMatrix();

            c++;
            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 210f) / 512f, yaxis - 2f * yaxis * (80f + (c % 3) * distanceFromTopToTop) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmTagVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.electricringnametag);

            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(-xaxis + 2f * xaxis * (70f + 330f) / 512f, yaxis - 2f * yaxis * (512f-80f) / 512f, 0f);
            rC.drawWithBuffers(gl, MR.getmIconRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, R.drawable.up);

            gl.glPopMatrix();
        }
        gl.glDisable(GL10.GL_TEXTURE);
        gl.glPopMatrix();



    }



    public void VEHICLE_MENU(Vehicles vehicle,int selected_vehicle){
        int textureID;
       /*
                * 0  The_Cube
                * 1  Motor
                * 2  Paper Plane
                * 3  Hang Glider
                * 4  Toy Airplane
                * 5  Zepplin
                * 6  Vintage Plane
                * 7  WarPlane
                * 8  PassengerPlane
                * 9  Space Shuttle
                * 10 Flying Saucer
                * 11 Electric Ring
                */

        if(false) {//highdef
            switch (vehicle.getID_NUMBER()) {
                case 0:
                    textureID = R.drawable.thecubemenuhighdef;
                    break;
                case 1:
                    textureID = R.drawable.motormenuhighdef;
                    break;
                case 2:
                    textureID = R.drawable.paperplanemenuhighdef;
                    break;
                case 3:
                    textureID = R.drawable.hangglidermenuhighdef;
                    break;
                case 4:
                    textureID = R.drawable.toyairplanemenuhighdef;
                    break;
                case 5:
                    textureID = R.drawable.zepplinmenuhighdef;
                    break;
                case 6:
                    textureID = R.drawable.vintagemenuhighdef;
                    break;
                case 7:
                    textureID = R.drawable.warplanemenuhighdef;
                    break;
                case 8:
                    textureID = R.drawable.passengerplanemenuhighdef;
                    break;
                case 9:
                    textureID = R.drawable.spaceshuttlemenuhighdef;
                    break;
                case 10:
                    textureID = R.drawable.flyingsaucermenuhighdef;
                    break;
                case 11:
                    textureID = R.drawable.electricringmenuhighdef;
                    break;
                default:
                    textureID = R.drawable.motormenuhighdef;
                    break;

            }
        } else{

            switch (vehicle.getID_NUMBER()) {
                case 0:
                    textureID =     R.drawable.thecubemenu;
                    break;
                case 1:
                    textureID =       R.drawable.motormenu;
                    break;
                case 2:
                    textureID =  R.drawable.paperplanemenu;
                    break;
                case 3:
                    textureID =  R.drawable.hangglidermenu;
                    break;
                case 4:
                    textureID = R.drawable.toyairplanemenu;
                    break;
                case 5:
                    textureID =  R.drawable.zepplinmenu;
                    break;
                case 6:
                    textureID =  R.drawable.vintagemenu;
                    break;
                case 7:
                    textureID = R.drawable.warplanemenu;
                    break;
                case 8:
                    textureID = R.drawable.passengerplanemenu;
                    break;
                case 9:
                    textureID = R.drawable.spaceshuttlemenu;
                    break;
                case 10:
                    textureID = R.drawable.flyingsaucermenu;
                    break;
                case 11:
                    textureID = R.drawable.electricringmenu;
                    break;
                default:
                    textureID = R.drawable.motormenu;
                    break;

            }
        }


        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);

        if (notDone000==true){
            gl.glTranslatef(0, 0, -0.001f);


        }

        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, textureID);



        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glPushMatrix();
        if (notDone000==true){
            gl.glTranslatef(0, 0, -0.0001f);
            notDone000=false;
        }


        // glMatrixMode (GL_MODELVIEW);
	    /*
	     *
	     * When modelview was active here and not commmented out the rectangles would not appear after
	     * I had pressed start and gone back to this menu
	     *
	     *
	     *
	     *
	     */


        for (int c=0;c<(int)vehicle.getHandling()+(int)vehicle.getHandlingPlus();c++){
            gl.glPushMatrix();
            {
                gl.glTranslatef(xaxis * (0.12f)+sizeOfStatRects*(float)c*xaxis, yaxis * 0.22f, 0.0000000000000000001f);

                //gl.glTranslatef(xaxis * (0.12f), yaxis * 0.22f, 0.000000000000001f);

                gl.glColor4f(0.4f + (float) c / 15f, (float) c / 15f, 0.2f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);
            }gl.glPopMatrix();

        }

        for (int c=0;c<(int)vehicle.getLuck()+(int)vehicle.getLuckPlus();c++){
            gl.glPushMatrix();
            {

                gl.glTranslatef(xaxis * (0.12f)+sizeOfStatRects*(float)c*xaxis, yaxis * -0.1f, 0.0000000000000000001f);

                //gl.glTranslatef(xaxis * (0.12f), yaxis * -0.1f, 0.000000000000001f);
                gl.glColor4f(0.2f + (float) c / 16f, 0.5f + (float) c / 15f, 0.2f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);
            }gl.glPopMatrix();

        }

        /*

        for (int c=0;c<(10-(vehicle.getSize()+vehicle.getSizePlus()));c++){
            gl.glPushMatrix();
            {

               // gl.glTranslatef(xaxis*(0.12f),yaxis*-0.45f,0.00000000000001f);
                gl.glTranslatef(xaxis * (0.12f)+sizeOfStatRects*(float)c*xaxis, yaxis * -0.45f, 0.0000000000000000001f);

                gl.glColor4f(0.4f + (float) c / 13f, (float) c / 19f, 0.5f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);
            }gl.glPopMatrix();

        }*/


        for (int c=0;c<(vehicle.getSize()+vehicle.getSizePlus());c++){
            gl.glPushMatrix();
            {

                // gl.glTranslatef(xaxis*(0.12f),yaxis*-0.45f,0.00000000000001f);
                gl.glTranslatef(xaxis * (0.12f)+sizeOfStatRects*(float)c*xaxis, yaxis * -0.45f, 0.0000000000000000001f);

                gl.glColor4f(0.4f + (float) c / 13f, (float) c / 19f, 0.5f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);
            }gl.glPopMatrix();

        }

        for (int c=0;c<(int)vehicle.getArmour()+(int)vehicle.getArmourPlus();c++){
            gl.glPushMatrix();
            {
                gl.glTranslatef(xaxis * (0.12f)+sizeOfStatRects*(float)c*xaxis, yaxis * -0.8f, 0.0000000000000000001f);

                gl.glColor4f(0.8f + (float) c / 15f, (float) c / 15f, 0.2f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);
            }gl.glPopMatrix();

        }


        if (vehicle.getBought()==1){
            textureID=R.drawable.tick;
        }else{
            textureID=R.drawable.lock;
        }
        gl.glPushMatrix();
        {
            gl.glTranslatef(xaxis * 0.72f, yaxis * 0.62f, 0.0000000000000000001f);

            gl.glColor4f(1f, 1f, 1f, 1f);
            rC.drawWithBuffers(gl, MR.getmMidRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, textureID);

        }gl.glPopMatrix();


        gl.glPopMatrix();


        gl.glDisable(GL10.GL_TEXTURE);
    }
    //Main ma=new Main();
    public void POWERUPS_MENU(){

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1F);

        if (notDone000==true){
            gl.glTranslatef(0, 0, -0.001f);

        }

        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, R.drawable.powerupshighdef);


        gl.glMatrixMode (GL10.GL_PROJECTION);
        gl.glPushMatrix();
        if (notDone000==true){
            gl.glTranslatef(0, 0, -0.0001f);
            notDone000=false;
        }


        // glMatrixMode (GL_MODELVIEW);
	    /*
	     *
	     * When modelview was active here and not commmented out the rectangles would not appear after
	     * I had pressed start and gone back to this menu
	     *
	     *
	     *
	     *
	     */


        for (int c=0;c<(int)MR.getExtraFrequencyNumber();c++){
            gl.glPushMatrix();
            {
                gl.glTranslatef(xaxis * (0.35f) + sizeOfStatRects*(float)c*xaxis, yaxis * 0.6f, 0.00000000000001f);

                //gl.glTranslatef(xaxis * (0.35f), yaxis * 0.6f, 0.000000000000001f);


                gl.glColor4f(0.4f + (float) c / 15f, (float) c / 15f, 0.2f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);

            }gl.glPopMatrix();

        }

        for (int c=0;c<(int)MR.getSpeedyUpgradeNumber();c++){
            gl.glPushMatrix();
            {
                gl.glTranslatef(xaxis * (0.35f) + sizeOfStatRects*(float)c*xaxis, yaxis * 0.3f, 0.00000000000001f);

               // gl.glTranslatef(xaxis * (0.35f), yaxis * 0.3f, 0.000000000000001f);


                gl.glColor4f(0.2f + (float) c / 16f, 0.5f + (float) c / 15f, 0.2f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);

            }gl.glPopMatrix();

        }


        for (int c=0;c<MR.getInvincibilityUpgradeNumber();c++){
            gl.glPushMatrix();
            {

                gl.glTranslatef(xaxis * (0.35f) + sizeOfStatRects*(float)c*xaxis, yaxis * 0, 0.00000000000001f);

                gl.glColor4f(0.4f + (float) c / 13f, (float) c / 19f, 0.5f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);

            }gl.glPopMatrix();

        }


        for (int c=0;c<MR.getMagnetUpgradeNumber();c++){
            gl.glPushMatrix();
            {
                gl.glTranslatef(xaxis * (0.35f)+sizeOfStatRects*(float)c*xaxis, yaxis * -0.3f, 0.0000000000000000001f);

                gl.glColor4f(0.8f + (float) c / 15f, (float) c / 15f, 0.2f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(), MR.getmStandardRectInd(), 4);

            }gl.glPopMatrix();

        }

        for (int c=0;c<MR.getChestUpgradeNumber();c++){
            gl.glPushMatrix();
            {
                gl.glTranslatef(xaxis * (0.35f)+sizeOfStatRects*(float)c*xaxis, yaxis * -0.6f, 0.0000000000000000001f);

                gl.glColor4f(0.8f + (float) c / 15f, (float) c / 9f, 0.7f, 1f);
                rC.drawWithBuffers(gl, MR.getmSmallRectVerts(),MR.getmStandardRectInd(),4);

            }gl.glPopMatrix();

        }


        gl.glPopMatrix();


        gl.glDisable(GL10.GL_TEXTURE);
    }



    public void PAUSE_MENU(){
        int textureID=R.drawable.pausemenuhighdef;

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, -0.000000001f);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, textureID);

        gl.glDisable(GL10.GL_TEXTURE);
    }

    public void REVIVE_MENU(FontClass font,int cost){
        int textureID=R.drawable.revivemenuhighdef;

        gl.glDisable(GL10.GL_DEPTH_TEST);
        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(0, 0, -0.000000001f);
        rC.drawWithBuffers(gl, MR.getmStandardRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 6, textureID);

        String mainString=Integer.toString(cost);
        font.drawFont(-0.0f*xaxis,-0.08f+0.1f/2f,0,-xaxis*0.2f*(float)(mainString.length()),0.4f-0.1f,mainString);
//x-axis -0 minus is right
        gl.glDisable(GL10.GL_TEXTURE);
        gl.glEnable(GL10.GL_DEPTH_TEST);

    }

    public void TICK_ICON(){
        int textureID=R.drawable.tick;

        gl.glEnable(GL10.GL_TEXTURE);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glTranslatef(xaxis * 0.7f,yaxis*0.6f, 0);
        rC.drawWithBuffers(gl, MR.getmMidRectVerts(), MR.getmStandardRectUVCoordsVerts(), MR.getmStandardRectInd(), 4, textureID);

        gl.glDisable(GL10.GL_TEXTURE);
    }



/*
    public static Texture LoadTexture(String Key){
        try {
            return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/"+Key+".png")));
        } catch (FileNotFoundException e) {

            System.out.println("Developer error1");
            e.printStackTrace();
            return null;
        } catch (IOException e) {

            System.out.println("Developer error2");
            e.printStackTrace();
            return null;

        }
    }
    */
}

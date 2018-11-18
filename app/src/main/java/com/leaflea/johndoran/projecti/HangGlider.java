package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;


public class HangGlider extends Vehicles {

    public float[] getModelVertArray() {
        return modelVertArray;
    }

    public void setModelVertArray(float[] modelVertArray) {
        this.modelVertArray = modelVertArray;
    }

    public float[] getModelColorArray() {
        return modelColorArray;
    }

    public void setModelColorArray(float[] modelColorArray) {
        this.modelColorArray = modelColorArray;
    }

    public short[] getModelIndArray() {
        return modelIndArray;
    }
    public void setModelIndArray(short[] modelIndArray) {
        this.modelIndArray = modelIndArray;
    }

    public int getPrice() {
        return price;
    }
    public void setNoOfVertices(int noOfVertices) {
        this.noOfVertices = noOfVertices;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getBought() {
        return bought;
    }


    public void setBought(int bought) {
        this.bought = bought;
    }
    public Boolean getNotInitialized() {
        return notInitialized;
    }


    public void setNotInitialized(Boolean notInitialized) {
        this.notInitialized = notInitialized;
    }
    public float getArmourPlus() {
        return armourPlus;
    }


    public void setArmourPlus(float armourPlus) {
        this.armourPlus = armourPlus;
    }


    public float getHandlingPlus() {
        return handlingPlus;
    }


    public void setHandlingPlus(float handlingPlus) {
        this.handlingPlus = handlingPlus;
    }


    public float getLuckPlus() {
        return luckPlus;
    }


    public void setLuckPlus(float luckPlus) {
        this.luckPlus = luckPlus;
    }


    public float getSizePlus() {
        return sizePlus;
    }


    public void setSizePlus(float sizePlus) {
        this.sizePlus = sizePlus;
    }


    public int getID_NUMBER() {
        return ID_NUMBER;
    }


    public void setID_NUMBER(int iD_NUMBER) {
        ID_NUMBER = iD_NUMBER;
    }


    public float getXpos() {
        return xpos;
    }


    public void setXpos(float xpos) {
        this.xpos = xpos;
    }


    public float getYpos() {
        return ypos;
    }


    public void setYpos(float ypos) {
        this.ypos = ypos;
    }


    public float getZpos() {
        return zpos;
    }


    public void setZpos(float zpos) {
        this.zpos = zpos;
    }


    public float getLength() {
        return length;
    }


    public void setLength(float length) {
        this.length = length;
    }


    public float getWidth() {
        return width;
    }


    public void setWidth(float width) {
        this.width = width;
    }


    public float getHeight() {
        return height;
    }


    public void setHeight(float height) {
        this.height = height;
    }


    public float getXrot() {
        return xrot;
    }


    public void setXrot(float xrot) {
        this.xrot = xrot;
    }


    public float getYrot() {
        return yrot;
    }


    public void setYrot(float yrot) {
        this.yrot = yrot;
    }


    public float getZrot() {
        return zrot;
    }


    public void setZrot(float zrot) {
        this.zrot = zrot;
    }


    public float getXvel() {
        return xvel;
    }


    public void setXvel(float xvel) {
        this.xvel = xvel;
    }


    public float getYvel() {
        return yvel;
    }


    public void setYvel(float yvel) {
        this.yvel = yvel;
    }


    public float getZvel() {
        return zvel;
    }


    public void setZvel(float zvel) {
        this.zvel = zvel;
    }


    public float getWeight() {
        return weight;
    }


    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHandling(){
        float[] v=MR.getHandlings();
        return v[ID_NUMBER];
    }
    public float getLuck(){

        float[] v=MR.getLucks();
        return v[ID_NUMBER];
    }
    public float getSize(){
        float[] v=MR.getSizes();
        return v[ID_NUMBER];
    }
    public float getArmour(){
        float[] v=MR.getArmours();
        return  v[ID_NUMBER];
    }



    public float[] getVertices() {
        return vertices;
    }


    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }


    public int getNoOfVertices() {
        return noOfVertices;
    }

    public float[] getVertsCollide(){return vertices;}



    public int price=8000;
    public int bought=0;
    public float actualSize;
    public int ID_NUMBER=3;
    public Boolean notInitialized=true;

    double lastRotSpread;
    double rotSpread=110d;//This measure degrees from end to end of the glider IN DEGREES

    public float[] model;

    public float[] colors;
    public short[] indices;
    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();

    public HangGlider(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        MR=rC.getMR();
        this.gl=gl;
        setVariables();


        actualSize     =calculateSize();
        length  =10*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;

        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;

        if (notInitialized) {

            redoInitialisation();
        }

    }


    public void generateModel(){
        actualSize     =calculateSize();
        actualSize=actualSize/3f;//Will multiply by actual size at the very end of the function



        float heightAtOpen  =1f*actualSize;

        int peaks=10;
        float height=(float)(rotSpread/180d)*heightAtOpen;
        float backRaise=(float)(rotSpread/180d)*2f*actualSize;

        float radius=2f*actualSize;

        int cylSides=8;
        int cylStacks=3;

        model=new float[((peaks)*2+2)*3+cylSides*cylStacks*3*3];//includes centre point and extra peak

        model[0]=0;
        model[1]=0;
        model[2]=0;


        for(int c=0;c<peaks;c++){

            //if((float)c<=(float)peaks/2f) {                                                           //Do not multiply by 2 here as rotSpread should be divided by two
                model[3 + c * 2 * 3 + 0] = radius * (float) Math.sin(Math.toRadians(-rotSpread / 2d + rotSpread * (double) c / (double) peaks ));
            //}else{
            //    model[3 + c * 2 * 3 + 0] = -1f*radius * (float) Math.sin(Math.toRadians(-rotSpread / 2d + rotSpread * (double) c / (double) peaks ));
            //}
            model[3 + c * 2 * 3 + 1] = height / 2f+backRaise;
            model[3 + c * 2 * 3 + 2] = -radius * (float) Math.abs(Math.cos(Math.toRadians(-rotSpread / 2d + rotSpread * (double) c / (double) peaks)));


            //if((float)c+0.5f<=(float)peaks/2f) {
                model[3+((c)*2+1)*3+0] =radius*(float)Math.sin(Math.toRadians(-rotSpread / 2d + rotSpread* ((double)c+0.5d) / (double) peaks ));
            //}else{
            //    model[3+((c)*2+1)*3+0] =-1f*radius*(float)Math.sin(Math.toRadians(-rotSpread / 2d + rotSpread* ((double)c+0.5d) / (double) peaks ));
            //}
            model[3+((c)*2+1)*3+1] = -height/2f+backRaise;
            model[3+((c)*2+1)*3+2] =-radius*(float)Math.abs(Math.cos(Math.toRadians(-rotSpread / 2d + rotSpread * ((double) c + 0.5d) / (double) peaks)));
        }

        int h=peaks;
        //if((float)h<=(float)peaks/2f) {
            model[3 + h * 2 * 3 + 0] = radius * (float) Math.sin(Math.toRadians(-rotSpread / 2d + rotSpread * (double) h / (double) peaks ));
        //}else{
        //    model[3 + h * 2 * 3 + 0] = -radius * (float) Math.sin(Math.toRadians(-rotSpread / 2d + rotSpread * (double) h / (double) peaks ));
        //}
        model[3 + h * 2 * 3 + 1] = height / 2f+backRaise;
        model[3 + h * 2 * 3 + 2] = -radius * (float) Math.abs(Math.cos(Math.toRadians(-rotSpread / 2d + rotSpread * (double) h / (double) peaks)));


        float p1x=model[3 + (2) * 2 * 3 + 0];
        float p1y=model[3 + (2) * 2 * 3 + 1];
        float p1z=model[3 + (2) * 2 * 3 + 2];
        float p2x=model[3 + (peaks-3) * 2 * 3 + 0];
        float p2y=model[3 + (peaks-3) * 2 * 3 + 1];
        float p2z=model[3 + (peaks-3) * 2 * 3 + 2];


        float dist=(p2x-p1x);


        float barRadius=0.01f;
        float[] bottomBar=VerticesUtil.generateCylinder(0,0,barRadius,dist,cylSides,cylStacks);

        for(int c=0;c<bottomBar.length/3;c++){
            float hold=bottomBar[c*3+0];
            bottomBar[c*3+0]=bottomBar[c*3+2]+p1x;
            bottomBar[c*3+2]=hold+p1z;
        }
        float[] topBar=VerticesUtil.generateCylinder(0,0,barRadius,backRaise,cylSides,cylStacks);
        float[] topBar1=topBar.clone();
        float[] topBar2=topBar.clone();
        for(int c=0;c<topBar.length/3;c++){
            float hold=topBar1[c*3+1];
            topBar1[c*3+1]=topBar1[c*3+2];
            topBar1[c*3+2]=hold+p1z;
            topBar1[c*3+0]=topBar1[c*3+0]+p1x;

            hold=topBar2[c*3+1];
            topBar2[c*3+1]=topBar2[c*3+2];
            topBar2[c*3+2]=hold+p1z;
            topBar2[c*3+0]=topBar2[c*3+0]+p2x;
        }

        float[] bars=concatArrays(bottomBar, concatArrays(topBar1, topBar2));


        for(int c=0;c<bars.length;c++){
            model[((peaks)*2+2)*3+c]=bars[c];
        }



        //float mag=(float)Math.sqrt((double)(wingCylVertices[c*3+0]*wingCylVertices[c*3+0]+wingCylVertices[c*3+2]*wingCylVertices[c*3+2]));
        //float totalrot=30;
        //wingCylVertices[c*3+0]=mag*(float)Math.sin(totalrot);
        //wingCylVertices[c*3+2]=mag*(float)Math.cos(totalrot);//This could go wrong direction

        short[] singleBarInd=VerticesUtil.generateCylinderIndices(cylSides, cylStacks);
        short[] barsInd=concatIndicesArrays(singleBarInd,
                concatIndicesArrays(
                        singleBarInd
                                ,singleBarInd)
        );

        indices=new short[peaks*2*3+barsInd.length];
        for(int c=0;c<peaks*2;c++){
            indices[c*3+0]=0;
            indices[c*3+1]=(short)(c+1);
            indices[c*3+2]=(short)(c+2);
        }

        for(int c=0;c<barsInd.length;c++){
            indices[peaks*2*3+c]=(short)(((peaks)*2+2)+(int)barsInd[c]);
        }


        //indices[peaks*2*3+0]=0;
        //indices[peaks*2*3+1]=(short)(peaks*2+1);
        //indices[peaks*2*3+2]=(short)(peaks*2+2);

        colors=new float[(model.length)/3*4];
        colors[0]=0f;
        colors[1]=0f;
        colors[2]=0f;
        colors[3]=1f;
        for(int c=1;c<peaks+1;c++){
            colors[(c)*8-4+0]=0.8f;
            colors[(c)*8-4+1]=0.6f;
            colors[(c)*8-4+2]=0.125f;
            colors[(c)*8-4+3]=1f;

            colors[(c)*8+0]=0.75f;
            colors[(c)*8+1]=0.56f;
            colors[(c)*8+2]=0.11f;
            colors[(c)*8+3]=1f;

        }
        colors[(peaks+1)*8-4+0]=0.75f;
        colors[(peaks+1)*8-4+1]=0.56f;
        colors[(peaks+1)*8-4+2]=0.11f;
        colors[(peaks+1)*8-4+3]=1f;


        for(int c=0;c<bars.length/3;c++) {
            colors[(peaks + 1) * 8 + c * 4 + 0] = 0.3f;
            colors[(peaks + 1) * 8 + c * 4 + 1] = 0.3f;
            colors[(peaks + 1) * 8 + c * 4 + 2] = 0.3f;
            colors[(peaks + 1) * 8 + c * 4 + 3] = 1f;
        }

        lastRotSpread=rotSpread;

    }
    Boolean open=true;

    public void redoInitialisation() {
        actualSize     =calculateSize();
        length  =10*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;
        generateModel();
        noOfVertices=model.length;

        vertices =new float[noOfVertices];
        for (int c=0;c<noOfVertices/3;c++){
            vertices[c*3+0]= model[c*3+0]*width;
            vertices[c*3+1]= model[c*3+1]*height;
            vertices[c*3+2]= model[c*3+2]*length;
        }

        notInitialized=false;


        modelVertArray=new float[vertices.length];
        for (int c=0;c< modelVertArray.length;c++) {
            modelVertArray[c]=vertices[c];
        }
        setModelColorArray(new float[colors.length]);
        for (int c=0;c< modelColorArray.length;c++) {
            modelColorArray[c]=colors[c];
        }
        setModelIndArray(new short[indices.length]);
        for (int c=0;c< modelIndArray.length;c++) {
            modelIndArray[c]=indices[c];
        }
        //MR.setUpVehicleBuffers();
    }

    float r=0;
    double speed=2d;

    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){

        if(open){
            rotSpread=rotSpread+speed;
            if(rotSpread>120d){
                open=false;
            }
        }else{
            rotSpread=rotSpread-speed;
            if(rotSpread<80d){
                open=true;
            }
        }

        if(lastRotSpread!=rotSpread){
            generateModel();
            redoInitialisation();
            //MR.setUpVehicleBuffers();
            MR.setRedoBuffers(true);
        }

        MR=rC.getMR();
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;


        //r=r+10f;
        gl.glPushMatrix();
        {

            gl.glTranslatef(xpos, ypos, zpos);
            gl.glPushMatrix();
            {
                //gl.glRotatef(r,0,1f,0);

                gl.glRotatef(xrot, 0,1,0);
                gl.glRotatef(yrot, 1,0,0);
                gl.glRotatef(zrot, 0,0,1);

                rC.drawWithBuffers(gl, true, MR.getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), 36);

            }gl.glPopMatrix();
        }
        gl.glPopMatrix();
    }



}

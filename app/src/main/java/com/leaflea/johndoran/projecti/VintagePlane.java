package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

public class VintagePlane extends Vehicles {
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

    public int price=10000;
    public int bought=0;
    public float actualSize;
    public int ID_NUMBER=6;
    public Boolean notInitialized=true;


    //public float[] model={
    //        0,0,1f,
    //        -1,0.875f,0,    1,0.875f,0,
    //        -0.2f,1f,0,     0.2f,1f,0,
    //        0,0,1f,
    //        0,0,0
    //};
    //public float[] colors={0.9f,0.9f,0.9f,1f,    0.9f,0.9f,0.9f,1f,      0.9f,0.9f,0.9f,1f,     0.9f,0.9f,0.9f,1f,
    //        0.9f,0.9f,0.9f,1f,    0.1f,0.1f,0.1f,1f,    0.1f,0.1f,0.1f,1f};
    //public short[] indices={
    //        0,1,3,  0,2,4,
    //        3,5,6,  4,5,6
    //};

    public float[] model;
    public float[] colors;
    public short[] indices;
    GL10 gl;
    MyRenderer MR;
    renderController rC=new renderController();

    float g=0;
    public VintagePlane(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {

        MR=rC.getMR();
        this.gl=gl;
        setVariables();

        actualSize     =calculateSize();
        length  =5*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;

        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

        this.xrot=xrot;
        this.yrot=yrot;
        this.zrot=zrot;
        if (notInitialized){
            generateModel();

            noOfVertices=model.length;
            vertices =new float[noOfVertices];
            for (int c=0;c<noOfVertices/3;c++){
                vertices[c*3+0]= model[c*3+0]*width;
                vertices[c*3+1]= model[c*3+1]*height;
                vertices[c*3+2]= model[c*3+2]*length;
            }
            notInitialized=false;
        }
        setModelVertArray(new float[vertices.length]);
        for (int c=0;c< getModelVertArray().length;c++) {
            getModelVertArray()[c]=vertices[c];
        }
        setModelColorArray(new float[colors.length]);
        for (int c=0;c< getModelColorArray().length;c++) {
            getModelColorArray()[c]=colors[c];
        }
        setModelIndArray(new short[indices.length]);
        for (int c=0;c< getModelIndArray().length;c++) {
            getModelIndArray()[c]=indices[c];
        }
    }


    public void generateModel(){
        actualSize     =calculateSize();
        actualSize=actualSize/3f;


        length  =9*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;

        int verticesAlreadyDeclared=0;
        int nCylStacks=11;
        int nCylSides=32;
        float clippedWidth=2.5f*actualSize;
        float radius=3.5f*actualSize;
        float[] adjustedHeights={0.3f,0.5f,0.8f,1f,1f,0.9f,0.9f,0.9f,0.9f,0.9f,0.8f};

        float[] centreCyl=VerticesUtil.generateCylinder(0,0,radius,length,nCylSides,nCylStacks);
        for(int c=0;c<nCylStacks;c++){
            for(int d=0;d<centreCyl.length/3/nCylStacks;d++) {
                if(Math.abs(centreCyl[(c*nCylSides+d )* 3 + 0])>clippedWidth){
                    if(centreCyl     [(c*nCylSides+d )* 3 + 0]>0) {
                        centreCyl    [(c*nCylSides+d )* 3 + 0] = clippedWidth;
                    }else{
                        centreCyl[(c * nCylSides + d )* 3 + 0] = -clippedWidth;
                    }
                }
                centreCyl[c * nCylSides*3 +d * 3 + 0] = centreCyl[c * nCylSides*3 +d * 3 + 0] * adjustedHeights[c];

                centreCyl[c * nCylSides*3 +d * 3 + 1] = centreCyl[c * nCylSides*3 +d * 3 + 1] * adjustedHeights[c];
                //centreCyl[d * 3 + 2] = centreCyl[d * 3 + 2];
            }
        }

        float R=0.3f;
        float G=0.3f;
        float B=0.3f;



        short[] centreCylInd=VerticesUtil.generateCylinderIndicesPure(nCylSides,nCylStacks);



        short[] circle=new short[(nCylSides-2)*3*2];

        int dist=((nCylStacks-1)*nCylSides);
        for(int c=0;c<nCylSides-2;c++){
            circle[c*3+0]=(short)(0);
            circle[c*3+1]=(short)(c+1);
            circle[c*3+2]=(short)(c+2);

            circle[(c+nCylSides-2)*3+0]=(short)(dist+0);
            circle[(c+nCylSides-2)*3+1]=(short)(dist+c+1);
            circle[(c+nCylSides-2)*3+2]=(short)(dist+c+2);
        }
        centreCylInd=concatArrays(centreCylInd.clone(),circle);
        verticesAlreadyDeclared=verticesAlreadyDeclared+nCylSides*nCylStacks;


        float wingSpan=0.5f*actualSize;
        float wingWidth=1f*actualSize ;
        wingSpan =12f*actualSize;
        wingWidth=2f*actualSize;
        float wingDistance=radius*2.4f;
        float wingZPosition=length*0.35f;
        float cyl1XPos=wingSpan*0.45f;
        float cyl2XPos=wingSpan*0.85f;
        float supportCylRadius=0.5f*actualSize;

        int lilCylSides=4;
        float[] supportCylinderVertices=VerticesUtil.generateCylinder(0,0,supportCylRadius,wingDistance,lilCylSides,3);

        float hold;



        for(int c=0;c<supportCylinderVertices.length/3;c++){
            hold=supportCylinderVertices[c*3+2];
            supportCylinderVertices[c*3+2]=supportCylinderVertices[c*3+1];
            supportCylinderVertices[c*3+1]=hold;
        }


        float[] wing={
                    0,       0f,0,                   wingSpan,0f,0,
                    0,       0f,wingWidth,              wingSpan,0f,wingWidth,
                    0,       00.1f,0,                   wingSpan,00.1f,0,
                0,       00.1f,wingWidth,              wingSpan,00.1f,wingWidth           };


        short[] supportCylinderIndices=VerticesUtil.generateCylinderIndicesPure(lilCylSides, 3);

        short[] wingIndices={
                0,1,3,
                0,2,3,
                0,1,5,
                0,4,5,
                0,4,6,
                0,2,6,

                7,6,4,
                7,5,4,
                7,6,2,
                7,3,2,
                7,3,1,
                7,5,1};

        short[] fullWingIndices=concatIndicesArrays(concatIndicesArrays(wingIndices, supportCylinderIndices),concatIndicesArrays(wingIndices , supportCylinderIndices));

        //wing cyl wing cyl


        float[] fullWingVertices=new float[wing.length*2+supportCylinderVertices.length*2];
        for(int c=0;c<wing.length/3;c++){
            fullWingVertices[c*3+0]=wing[c*3+0];
            fullWingVertices[c*3+1]=wing[c*3+1]-wingDistance/2f+0f;
            fullWingVertices[c*3+2]=wing[c*3+2]+wingZPosition;

            fullWingVertices[(c)*3+0+wing.length*1+supportCylinderVertices.length]=wing[c*3+0];
            fullWingVertices[(c)*3+1+wing.length*1+supportCylinderVertices.length]=wing[c*3+1]+wingDistance/2f+0f;
            fullWingVertices[(c)*3+2+wing.length*1+supportCylinderVertices.length]=wing[c*3+2]+wingZPosition;
        }

        for(int c=0;c<supportCylinderVertices.length/3;c++){
            fullWingVertices[c*3+0+wing.length*1]=supportCylinderVertices[c*3+0]+cyl1XPos;
            fullWingVertices[c*3+1+wing.length*1]=supportCylinderVertices[c*3+1]-wingDistance/2f+0f;
            fullWingVertices[c*3+2+wing.length*1]=supportCylinderVertices[c*3+2]+wingZPosition+wingWidth/2f;

            fullWingVertices[c*3+0+supportCylinderVertices.length+wing.length*2]=supportCylinderVertices[c*3+0]+cyl2XPos;
            fullWingVertices[c*3+1+supportCylinderVertices.length+wing.length*2]=supportCylinderVertices[c*3+1]-wingDistance/2f+0f;
            fullWingVertices[c*3+2+supportCylinderVertices.length+wing.length*2]=supportCylinderVertices[c*3+2]+wingZPosition+wingWidth/2f;
        }


        float[] wing2Verts=fullWingVertices.clone();
        for(int c=0;c<wing2Verts.length/3;c++){
            wing2Verts[c*3+0]=wing2Verts[c*3+0]*-1f;
        }

        short[] bothWingIndices = concatIndicesArrays(fullWingIndices,fullWingIndices);

        float rudderLength=2f*actualSize;
        float rudderHeight=radius*8f*actualSize;
        float rudderWidth=clippedWidth*actualSize;
        float rudderX=0;
        float rudderY=centreCyl[1];
        float rudderZ=centreCyl[2+3];

        float[] rudderVerts={
                -rudderWidth/2f      ,0                  ,-0,                    rudderWidth/2f        ,0                 ,0,
                -rudderWidth/2f*0.8f ,rudderHeight       ,-rudderLength*0.2f,                    rudderWidth/2f*0.8f   ,rudderHeight      ,-rudderLength*0.2f,
                -rudderWidth/2f*0.8f ,0                  ,-rudderLength*0.8f,    rudderWidth/2f*0.8f   ,0                 ,-rudderLength*0.8f,
                -rudderWidth/2f*0.5f ,rudderHeight*0.8f  ,-rudderLength,    rudderWidth/2f*0.5f   ,rudderHeight*0.8f ,-rudderLength

        };



        short[] rudderIndices={
                0,1,3,
                0,2,3,
                0,1,5,
                0,4,5,
                0,4,6,
                0,2,6,

                7,6,4,
                7,5,4,
                7,6,2,
                7,3,2,
                7,3,1,
                7,5,1
        };
        indices=concatIndicesArrays(
                centreCylInd
                ,
                concatIndicesArrays(
                        bothWingIndices,
                        rudderIndices

                )
        )
        ;
        model=concatArrays(
                centreCyl
                , concatArrays(fullWingVertices
                ,
                concatArrays(
                        wing2Verts
                        , rudderVerts
                )
                )
        )
        ;

        for(int c=0;c<model.length/3;c++){
            model[c*3+2]=model[c*3+2]-length/2f;
        }

        colors=new float[(findMaxElement(indices)+1)*4];

        for(int c=0;c<centreCyl.length/3;c++){
            //R=0.3f+(float)c/(float)(centreCyl.length/3)*0.3f;
            //G=0.3f+(float)c/(float)(centreCyl.length/3)*0.4f;
            //B=0.3f+(float)c/(float)(centreCyl.length/3)*0.5f;

            R=223f/256f+(float)c/(float)(centreCyl.length/3)*0.08f;
            G=209f/256f+(float)c/(float)(centreCyl.length/3)*0.08f;
            B= 32f/256f+(float)c/(float)(centreCyl.length/3)*0.01f;

            colors[c*4+0]=R;
            colors[c*4+1]=G;
            colors[c*4+2]=B;
            colors[c*4+3]=1f;


        }


        for(int c=(int)((float)nCylStacks*0.45f);c<(int)((float)nCylStacks*.55f);c++){
            R=0f;
            G=0f;
            B=0f;

            int width=(int)(((float)nCylStacks*.5f*1f)*((float)nCylStacks*0.1f)-Math.abs((int)((float)nCylStacks*0.5f)-c));
            for(int d=(int)((float)nCylSides/4f)-width;d<(int)((float)nCylSides/4f)+width;d++) {

                colors[c*nCylSides * 4+d*4 + 0] = R;
                colors[c*nCylSides * 4+d*4 + 1] = G;
                colors[c*nCylSides * 4+d*4 + 2] = B;
                colors[c*nCylSides * 4+d*4 + 3] = 1f;

            }

        }


        R=217f/256f;
        G=128f/256f;
        B=038f/256f;
        for(int c=0;c<wing.length/3;c++){//wing


            colors[centreCyl.length/3*4+c*4+0]=R;
            colors[centreCyl.length/3*4+c*4+1]=G;
            colors[centreCyl.length/3*4+c*4+2]=B;
            colors[centreCyl.length/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length)/3*4+c*4+3]=1f;


        }

        R=0.1f;
        G=0.1f;
        B=0.1f;
        for(int c=0;c<supportCylinderVertices.length/3;c++){//support cylinders


            colors[(centreCyl.length+wing.length)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length)/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length)/3*4+c*4+3]=1f;


        }

        R=217f/256f;
        G=128f/256f;
        B=038f/256f;
        for(int c=0;c<wing.length/3;c++){//wing


            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length*1+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+3]=1f;


        }


        R=0.1f;
        G=0.1f;
        B=0.1f;
        for(int c=0;c<supportCylinderVertices.length/3;c++){


            colors[(centreCyl.length+wing.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wing.length*2+supportCylinderVertices.length+wing.length*2+supportCylinderVertices.length*2)/3*4+c*4+3]=1f;


        }

        R=0.4f;
        G=0.4f;
        B=0.4f;

        //Rudder
        for(int c=0;c<rudderVerts.length/3;c++){



            colors[(centreCyl.length+(wing.length*2+supportCylinderVertices.length*2)*2)/3*4+c*4+0]=R-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*R/1f;
            colors[(centreCyl.length+(wing.length*2+supportCylinderVertices.length*2)*2)/3*4+c*4+1]=G-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*G/1f;
            colors[(centreCyl.length+(wing.length*2+supportCylinderVertices.length*2)*2)/3*4+c*4+2]=B-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*B/1f;
            colors[(centreCyl.length+(wing.length*2+supportCylinderVertices.length*2)*2)/3*4+c*4+3]=1f;


        }
        if(colors.length/4*3!=model.length){
        for(int c=0;c<colors.length/4;c++){
            colors[c*4+0]=0.5f;
            colors[c*4+1]=0.5f;
            colors[c*4+2]=0.5f;
            colors[c*4+3]=1f;


        }
        }
    }

    public static short[] concatIndicesArrays(short[] on, short[] tw){
        short[] one=on.clone();
        short[] two=tw.clone();

        short[] product=concatArrays(one,increaseValueOfAllElements(two,(short)(findMaxElement(one)+1)));
        return product;
    }

    public static short[] concatIndicesArrays1(short[] one, short[] two){

        short[] product=concatArrays(one, increaseValueOfAllElements(two, (short) (findMaxElement(one) + 1)));
        return product;
    }
    public static float[] concatArrays(float[] on,float[] tw){
        float[] one=on.clone();
        float[] two=tw.clone();

        float[] product=new float[one.length+two.length];
        for(int c=0;c<(one.length);c++){
            product[c]=one[c];
        }
        for(int c=0;c<(two.length);c++){
            product[one.length+c]=two[c];
        }

        return product;
    }
    public static short[] concatArrays(short[] on,short[] tw){
        short[] one=on.clone();
        short[] two=tw.clone();
        short[] product=new short[one.length+two.length];
        for(int c=0;c<(one.length);c++){
            product[c]=one[c];
        }
        for(int c=0;c<(two.length);c++){
            product[one.length+c]=two[c];
        }

        return product;
    }

    public static short findMaxElement(short[] arr){
        short maxNum;
        if(arr.length>0){
            maxNum=arr[0];
            for(int c=0;c<arr.length;c++){
                if(maxNum<arr[c]){
                    maxNum=arr[c];
                }
            }
            return maxNum;
        }else {
            return 0;
        }
    }

    public static short[] increaseValueOfAllElements(short[] ar,short increase){

        short[] one=ar.clone();
        for(int c=0;c<one.length;c++){
            one[c]=(short)(one[c]+increase);
        }

        return one;
    }
    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){
        redoInitialisation();
        MR=rC.getMR();
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;

      //  g=g+5f;
        gl.glPushMatrix();
        {
            gl.glTranslatef(xpos, ypos, zpos);

            gl.glPushMatrix();
            {
                gl.glRotatef(xrot, 0,1,0);
                gl.glRotatef(yrot, 1,0,0);
                gl.glRotatef(zrot, 0,0,1);

                rC.drawWithBuffers(gl, true, MR.getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), 36);
            }gl.glPopMatrix();


        }

        gl.glPopMatrix();
    }




}

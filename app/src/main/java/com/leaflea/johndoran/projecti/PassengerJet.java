package com.leaflea.johndoran.projecti;

import javax.microedition.khronos.opengles.GL10;

public class PassengerJet extends Vehicles {
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

    public int price=15000;
    public int bought=0;
    public float actualSize;
    public int ID_NUMBER=8;//Change this later
    public Boolean notInitialized=true;

    public float propZ=0;
    public float propX=0;
    public float propY=0;

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
    renderController rC;

    float g=0;
    public PassengerJet(GL10 gl,float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot) {
        rC=new renderController();
        MR=rC.getMR();
        this.gl=gl;
        setVariables();

        actualSize     =1f;

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
            vertices=model;
            noOfVertices=model.length;
            vertices =new float[noOfVertices];
            for (int c=0;c<noOfVertices/3;c++){
                vertices[c*3+0]= model[c*3+0]*width;
                vertices[c*3+1]= model[c*3+1]*height;
                vertices[c*3+2]= model[c*3+2]*length;
                if(vertices[c*3+2]>propZ){
                    propZ=vertices[c*3+2];
                    propY=vertices[c*3+1];
                    propX=vertices[c*3+0];

                }
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
        //actualSize=1f;
        actualSize     =calculateSize();
        actualSize=actualSize/3f;


        length  =8f*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;

        int verticesAlreadyDeclared=0;
        int nCylStacks=20;
        int nCylSides=16;


        //float radius=3.5f*actualSize;


        /*
        This is the model I used
        00000000000000000000
        00000000000000000000
        00000000000000000000
        11111111111111110000
        11111111111111111100
        01111111111111111111
        00011111111111111111
        00000111111111111100
        00000000000000000000
        00000000000000000000

        radius=2.5f
        heights:0.4f, 0.6f,0.6f,0.8f,1,1,1,1,1,1,1,1,1,1,1,0.8f,0.8f,0.4f,0.4f
        pos    :+1.5f,1f,1f,0.5f,0.5f ,0,0,0,0,0,0,0,0,0,0,0,-0.5f,-0.5f,-0.5f*/
        float scale=7f/5f;


        float radius =2.5f*scale*actualSize;

        //back -> front of plane
        //float[] adjustedHeights={0.4f, 0.6f,0.6f,0.8f,1    ,1          ,1,1,1,1,1,1,1,1,1,1,   0.8f,0.8f,0.4f,0.4f};
        //float[] adjustedPos={   +1.5f,   1f,  1f,0.5f,0.5f ,0    ,0,0,0,0,0,0,0,0,0,0,0,-0.5f,-0.5f,-0.5f};

        float[] adjustedHeights={0.4f ,0.6f ,0.6f ,0.6f  ,0.8f ,1,1,1,1,1,1,1,1,1,1, 0.87f,0.74f,0.61f  ,0.48f ,0.35f};
        float[] adjustedPos=    {0.5f,0.5f,0.5f,0.5f ,0        ,0,0,0,0,0,0,0,0,0,0,-0.17f,-0.34f,-0.51f    ,-0.68f   ,-0.85f};

        for(int c=0;c<adjustedPos.length;c++) {
            adjustedPos[c%adjustedPos.length]=adjustedPos[c%adjustedPos.length]/2.5f        *radius;
        }





        float[] centreCyl=VerticesUtil.generateCylinder(0,0,radius,length,nCylSides,nCylStacks);



        for(int c=0;c<nCylStacks;c++){
            for(int d=0;d<nCylSides;d++) {

                centreCyl[c * nCylSides*3 +d * 3 + 0] = centreCyl[c * nCylSides*3 +d * 3 + 0]*adjustedHeights[c%adjustedHeights.length]*0.8f;

                centreCyl[c * nCylSides*3 +d * 3 + 1] = (centreCyl[c * nCylSides*3 +d * 3 + 1]*adjustedHeights[c%adjustedHeights.length])+adjustedPos[c%adjustedPos.length];
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


        //float wingSpan=0.5f*actualSize;
        //float wingWidth=1f*actualSize ;
        //wingSpan =12f*actualSize;
        //wingWidth=2f*actualSize;
        float wingSpan=radius*3f;
        float wingZPosition=length*0.45f;
        float wingThickness=1f*actualSize;

        int wingCylSides=20;
        int wingCylStacks=20;

        float[] wingCylVertices=VerticesUtil.generateCylinder(0,0,wingThickness,wingSpan,wingCylSides,wingCylStacks);

        float hold;

        float rot=15f;
        for(int c=0;c<wingCylVertices.length/3;c++){
            hold=wingCylVertices[c*3+2];
            wingCylVertices[c*3+2]=wingCylVertices[c*3+0];
            wingCylVertices[c*3+0]=hold;

            //float mag=(float)Math.sqrt((double)(wingCylVertices[c*3+0]*wingCylVertices[c*3+0]+wingCylVertices[c*3+2]*wingCylVertices[c*3+2]));
            ////float totalrot=30+(float)Math.atan((double)(wingCylVertices[c*3+0]/wingCylVertices[c*3+2]));
            //float totalrot=rot;
            //wingCylVertices[c*3+0]=mag*(float)Math.sin(Math.toRadians(totalrot));
            //wingCylVertices[c*3+2]=mag*(float)Math.cos(Math.toRadians(totalrot));//This could go wrong direction

        }


        for(int c=0;c<wingCylStacks-1;c++){
            for(int d=0;d<wingCylSides;d++) {
                wingCylVertices[c * wingCylSides*3 +d * 3 + 1] = wingCylVertices[c * wingCylSides*3 +d * 3 + 1]*1f;
            }
        }

        {
            for (int d = 0; d < nCylSides; d++) {
                wingCylVertices[(wingCylStacks-1) * wingCylSides * 3 + d * 3 + 1] = wingCylVertices[(wingCylStacks-1) * wingCylSides * 3 + d * 3 + 1] * 0.5f+1.5f*radius;
            }
        }


       short[] wingCylIndices=VerticesUtil.generateCylinderIndicesPure(wingCylSides, wingCylStacks);



        //short[] fullWingIndices=concatIndicesArrays(wingCylIndices, wingCylIndices);
        short[] fullWingIndices=wingCylIndices;



        //wing cyl wing cyl


        for(int c=0;c<wingCylVertices.length/3;c++){
            wingCylVertices[c*3+2]=wingCylVertices[c*3+2]+wingZPosition;
        }



        float[] wing2Verts=wingCylVertices.clone();
        for(int c=0;c<wing2Verts.length/3;c++){
            wing2Verts[c*3+0]=wing2Verts[c*3+0]*-1f;
        }

        short[] bothWingIndices = concatIndicesArrays(fullWingIndices,fullWingIndices);




        /////////////////////////////////////////STOPPED HERE!



        float rudderLength=2f*actualSize;
        float rudderHeight=radius*8f*actualSize;
        float rudderWidth=0.75f*actualSize;
        float rudderX=0;
        float rudderY=centreCyl[1];
        float rudderZ=centreCyl[2+3];

        float[] rudderVerts={
                -rudderWidth/2f      ,0,-0,                                 rudderWidth/2f     ,0                ,-rudderLength*0.2f,
                -rudderWidth/2f*0.8f ,rudderHeight*0.8f,-0,                 rudderWidth/2f*0.8f,rudderHeight     ,-rudderLength*0.2f,
                -rudderWidth/2f*0.8f ,0,-rudderLength*0.8f,                 rudderWidth/2f*0.8f,0                ,-rudderLength,
                -rudderWidth/2f*0.5f ,rudderHeight*0.8f,-rudderLength*0.8f, rudderWidth/2f*0.5f,rudderHeight     ,-rudderLength

        };

        float[] allRudderVerts=new float[rudderVerts.length*3];

        hold=0;
        for(int c=0;c<rudderVerts.length/3;c++){

            allRudderVerts[(c)*3+0]=rudderVerts[(c)*3+0];
            allRudderVerts[(c)*3+1]=rudderVerts[(c)*3+1];
            allRudderVerts[(c)*3+2]=rudderVerts[(c)*3+2];

            allRudderVerts[(c)*3+0+rudderVerts.length  ]   =   rudderVerts[(c)*3+1];
            allRudderVerts[(c)*3+1+rudderVerts.length  ]   =   rudderVerts[(c)*3+0];
            allRudderVerts[(c)*3+2+rudderVerts.length  ]   =   rudderVerts[(c)*3+2];

            allRudderVerts[(c)*3+0+rudderVerts.length*2] =  -1*rudderVerts[(c)*3+1];
            allRudderVerts[(c)*3+1+rudderVerts.length*2] =   rudderVerts[(c)*3+0];
            allRudderVerts[(c)*3+2+rudderVerts.length*2] =   rudderVerts[(c)*3+2];

        }

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
                        concatIndicesArrays(
                                rudderIndices,
                                concatIndicesArrays(
                                        rudderIndices,
                                        rudderIndices

                                )

                        )

                )
        )
        ;
        model=concatArrays(
                centreCyl
                , concatArrays(wingCylVertices
                        ,
                        concatArrays(
                                wing2Verts
                                , allRudderVerts
                        )
                )
        )
        ;
/*
        for(int c=0;c<model.length/3;c++){
            model[c*3+2]=model[c*3+2]-length/2f;
        }*/


        colors=new float[(findMaxElement(indices)+1)*4];

        for(int c=0;c<centreCyl.length/3;c++){
            //R=0.3f+(float)c/(float)(centreCyl.length/3)*0.3f;
            //G=0.3f+(float)c/(float)(centreCyl.length/3)*0.4f;
            //B=0.3f+(float)c/(float)(centreCyl.length/3)*0.5f;


            if(((c%((float)nCylSides)>(float)nCylSides/20f* 11f && c%(float)(nCylSides)<(float)nCylSides/20f*19f)&&(float)c/(float)nCylSides>(float)nCylStacks/10f)||
                (c%((float)nCylSides)>(float)nCylSides/20f*1f   && c%(float)(nCylSides)<(float)nCylSides/20f*9f )&&(float)c/(float)nCylSides>(float)nCylStacks/10f)     {
                float co=((float)c/(float)nCylSides)/(float)nCylStacks*0.5f;
                R=0.5f+co;
                G=0.5f+co;
                B=0.5f+co;
            }else{
                R=0.1f;
                G=0.1f;
                B=0.9f;
            }

            colors[c * 4 + 0] = R;
            colors[c * 4 + 1] = G;
            colors[c * 4 + 2] = B;
            colors[c * 4 + 3] = 1f;
        }

        R=0f;
        G=152f/256f;
        B=225f/256f;
        for(int c=0;c<wingCylVertices.length/3;c++){


            colors[centreCyl.length/3*4+c*4+0]=R;
            colors[centreCyl.length/3*4+c*4+1]=G;
            colors[centreCyl.length/3*4+c*4+2]=B;
            colors[centreCyl.length/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+3]=1f;


        }
/*
        R=1f;
        G=1f;
        B=1f;
        for(int c=0;c<wingCylVertices.length/3;c++){


            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length)/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length)/3*4+c*4+3]=1f;


        }

        R=1f;
        G=1f;
        B=1f;
        for(int c=0;c<wingCylVertices.length/3;c++){


            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wingCylVertices.length*1+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length*1+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length*1+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length*1+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+3]=1f;


        }

        R=1f;
        G=1f;
        B=1f;
        for(int c=0;c<wingCylVertices.length/3;c++){


            colors[(centreCyl.length+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+3]=1f;

            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+0]=R;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+1]=G;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+2]=B;
            colors[(centreCyl.length+wingCylVertices.length*2+wingCylVertices.length+wingCylVertices.length*2+wingCylVertices.length*2)/3*4+c*4+3]=1f;


        }
*/
        R=0f;
        G=152f/256f;
        B=225f/256f;

        //Rudder
        for(int c=0;c<rudderVerts.length/3;c++){



            colors[(centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+0]=R-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*R/1f;
            colors[(centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+1]=G-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*G/1f;
            colors[(centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+2]=B-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*B/1f;
            colors[(centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+3]=1f;

            colors[(rudderVerts.length+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+0]=R-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*R/1f;
            colors[(rudderVerts.length+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+1]=G-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*G/1f;
            colors[(rudderVerts.length+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+2]=B-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*B/1f;
            colors[(rudderVerts.length+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+3]=1f;

            colors[(rudderVerts.length*2+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+0]=R-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*R/1f;
            colors[(rudderVerts.length*2+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+1]=G-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*G/1f;
            colors[(rudderVerts.length*2+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+2]=B-((float)c-(float)rudderVerts.length)/((float)rudderVerts.length)*B/1f;
            colors[(rudderVerts.length*2+centreCyl.length+(wingCylVertices.length*2))/3*4+c*4+3]=1f;


        }
        if(colors.length/4*3!=model.length){
            for(int c=0;c<colors.length/4;c++){
                colors[c*4+0]=0.5f;
                colors[c*4+1]=0.5f;
                colors[c*4+2]=0.5f;
                colors[c*4+3]=1f;


            }
        }

        //colors=new float[(findMaxElement(indices)+1)*4];


        /*colors=new float[model.length/3*4];

        for(int c=0;c<colors.length/4;c++){
            colors[c*4+0]=R+((float)c/(float)colors.length*4f)*1.6f%1f;
            colors[c*4+1]=G;
            colors[c*4+2]=B+((float)c/(float)colors.length*4f)*0.6f%1f;
            colors[c*4+3]=1f;
        }*/
    }

    public static short[] concatIndicesArrays(short[] on, short[] tw){
        short[] one=on.clone();
        short[] two=tw.clone();

        short[] product=concatArrays(one,increaseValueOfAllElements(two,(short)(findMaxElement(one)+1)));
        return product;
    }

    public static short[] concatIndicesArrays1(short[] one, short[] two){

        short[] product=concatArrays(one,increaseValueOfAllElements(two,(short)(findMaxElement(one)+1)));
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
    Miscellaneous m=new Miscellaneous();
    public void Render(float MotorX,float MotorY,float MotorZ,float xrot,float yrot,float zrot){
        redoInitialisation();
        MR=rC.getMR();
        this.xpos=MotorX;
        this.ypos=MotorY;
        this.zpos=MotorZ;
        actualSize=calculateSize();
        actualSize=actualSize/3f;
        length  =5*actualSize;
        width   =3*actualSize;
        height  =3*actualSize;

          g=g+5f;
        gl.glPushMatrix();
        {
            gl.glTranslatef(xpos, ypos, zpos);

            gl.glRotatef(xrot, 0,1,0);
            gl.glRotatef(yrot, 1,0,0);
            gl.glRotatef(zrot, 0,0,1);

            gl.glPushMatrix();
            {
                rC.drawWithBuffers(gl, true, MR.getmVehicleVerts(), MR.getmVehicleColor(), MR.getmVehicleInd(), 36);


            gl.glPushMatrix();
            {
                gl.glTranslatef(propX, propY, propZ);

                gl.glRotatef(g, 0, 0, 1);

                rC.drawWithBuffers(gl, true, rC.vertexBufferGenerator(m.rotorVerts(2f * actualSize)), rC.colorsBufferGenerator(m.rotorColor(255f / 256f, 128f / 256f, 0.25f)), rC.indexBufferGenerator(m.rotorIndices()), 36);

            }gl.glPopMatrix();
            }gl.glPopMatrix();

        }

        gl.glPopMatrix();
    }
    public  void fixVerts(){
        float maxX=0;
        float maxY=0;
        float maxZ=0;
        float minX=0;
        float minY=0;
        float minZ=0;

        float[] ve=this.getModelVertArray();
        for(int c=0;c<ve.length/3;c++){
            if(ve[c*3+0]<minX){
                minX=ve[c*3+0];
            }else if(ve[c*3+0]>maxX){
                maxX=ve[c*3+0];
            }

            if(ve[c*3+1]<minY){
                minY=ve[c*3+1];
            }else if(ve[c*3+1]>maxY){
                maxY=ve[c*3+1];
            }

            if(ve[c*3+2]<minZ){
                minZ=ve[c*3+2];
            }else if(ve[c*3+2]>maxZ){
                maxZ=ve[c*3+2];
            }
        }

        float difX=maxX-Math.abs(minX);
        float difY=maxY-Math.abs(minY);
        float difZ=maxZ-Math.abs(minZ);
        float propX=1f;
        float propY=1f;
        float propZ=1f;

        for(int c=0;c<ve.length/3;c++) {
            ve[c*3+0]=(ve[c*3+0]-difX/2f)*propX;
            ve[c*3+1]=(ve[c*3+1]-difY/2f)*propY;
            ve[c*3+2]=(ve[c*3+2]-difZ/2f)*propZ;
        }

        this.propX=(this.propX-difX/2f)*propX;//coincidence that propX`s have same name, one means propotion other mean propeller
        this.propY=(this.propY-difX/2f)*propY;
        this.propZ=(this.propZ-difX/2f)*propZ;
        this.propZ=(maxZ-difZ/2f)*propZ;

        this.setModelVertArray(ve);

        ve=this.getModel2();




        for(int c=0;c<ve.length/3;c++) {
            ve[c*3+0]=(ve[c*3+0]-difX/2f)*propX;
            ve[c*3+1]=(ve[c*3+1]-difY/2f)*propY;
            ve[c*3+2]=(ve[c*3+2]-difZ/2f)*propZ;
        }


        this.setSecondRingVertsArray(ve);

    }
}

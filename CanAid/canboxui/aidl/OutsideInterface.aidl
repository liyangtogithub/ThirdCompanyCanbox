package com.landsem.canboxui.aidl;


interface OutsideInterface
{
    void sendRadar(int frontLeft , int frontMidLeft, int frontMidRight ,int frontRight,
                   int backLeft , int backMidLeft, int backMidRight ,int backRight);
	
    void sendConner(boolean isLeft,int value);
}
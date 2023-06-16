package com.landsem.canbox;

import com.landsem.canbox.comparse.hiworld.DasAutoParse;
import com.landsem.canbox.comparse.hiworld.FordParse;
import com.landsem.canbox.comparse.hiworld.GmParse;
import com.landsem.canbox.comparse.hiworld.HarvardCoupeParse;
import com.landsem.canbox.comparse.hiworld.HarvardH6Parse;
import com.landsem.canbox.comparse.hiworld.HondaParse;
import com.landsem.canbox.comparse.hiworld.HwMazdaParse;
import com.landsem.canbox.comparse.hiworld.HyunDaiParse;
import com.landsem.canbox.comparse.hiworld.KoDiakParse;
import com.landsem.canbox.comparse.hiworld.NissanParse;
import com.landsem.canbox.comparse.hiworld.PsaParse;
import com.landsem.canbox.comparse.hiworld.ToyotaParse;
import com.landsem.canbox.comparse.hiworld.ToyotaPradoParse;
import com.landsem.canbox.comparse.hiworld.TrumpchiParse;
import com.landsem.canbox.comparse.raise.GeelyParse;
import com.landsem.canbox.comparse.raise.PrettySSParse;
import com.landsem.canbox.comparse.raise.VenuciaParse;
import com.landsem.canbox.comparse.raise.BaoJunParse;
import com.landsem.canbox.comparse.simple.DasAuto1Parse;
import com.landsem.canbox.comparse.simple.DasAuto2Parse;
import com.landsem.canbox.comparse.simple.EdgeParse;
import com.landsem.canbox.comparse.simple.FocusParse;
import com.landsem.canbox.comparse.simple.SMazdaParse;
import com.landsem.canbox.comparse.simple.XGMParse;
import com.landsem.canbox.comparse.simple.XPsaParse;
import com.landsem.canbox.comparse.xinbas.*;
import com.landsem.canbox.comparse.simple.TOYOT1Parse;
import com.landsem.canbox.comparse.simple.XHondaParse;
import com.landsem.canbox.comparse.simple.XTLParse;
import com.landsem.canbox.comparse.union.BmwParse;
import com.landsem.canbox.pack.SimpleBaseComPack;
import com.landsem.canbox.pack.hiworld.DasAutoPack;
import com.landsem.canbox.pack.hiworld.FordPack;
import com.landsem.canbox.pack.hiworld.GmPack;
import com.landsem.canbox.pack.hiworld.HondaPack;
import com.landsem.canbox.pack.hiworld.HwMazdaPack;
import com.landsem.canbox.pack.hiworld.HyunDaiPack;
import com.landsem.canbox.pack.hiworld.KoDiakPack;
import com.landsem.canbox.pack.hiworld.NissanPack;
import com.landsem.canbox.pack.hiworld.PsaPack;
import com.landsem.canbox.pack.hiworld.ToyotaPack;
import com.landsem.canbox.pack.hiworld.ToyotaPradoPack;
import com.landsem.canbox.pack.raise.VenuciaPack;
import com.landsem.canbox.pack.simple.DasAuto1Pack;
import com.landsem.canbox.pack.simple.DasAuto2Pack;
import com.landsem.canbox.pack.simple.FocusPack;
import com.landsem.canbox.pack.simple.SimpleMazdaPack;
import com.landsem.canbox.pack.simple.Toyot1Pack;
import com.landsem.canbox.pack.union.BmwPack;
import com.landsem.canbox.pack.xinbas.XinbasMazdaPack;


public enum ProtocolID{
	
	ID_HIWORLD_GM(38400, GmParse.class.getName(), GmPack.class.getName()),
	ID_HIWORLD_DASAUTO(38400, DasAutoParse.class.getName(), DasAutoPack.class.getName()),
	ID_HIWORLD_TOYOTA(38400, ToyotaParse.class.getName(), ToyotaPack.class.getName()),
	ID_HIWORLD_PSA(38400, PsaParse.class.getName(), PsaPack.class.getName()),
	ID_HIWORLD_FORD(38400, FordParse.class.getName(), FordPack.class.getName()),
	ID_HIWORLD_HONDA(38400, HondaParse.class.getName(), HondaPack.class.getName()),
	ID_HIWORLD_HYUNDAI(38400, HyunDaiParse.class.getName(), HyunDaiPack.class.getName()),
	ID_HIWORLD_NISSAN(38400, NissanParse.class.getName(), NissanPack.class.getName()),
	ID_HIWORLD_KODIAK(38400, KoDiakParse.class.getName(), KoDiakPack.class.getName()),
	ID_BMW(38400, BmwParse.class.getName(), BmwPack.class.getName()),
	ID_VENUCIA(38400, VenuciaParse.class.getName(), VenuciaPack.class.getName()),
	ID_FOCUS(38400, FocusParse.class.getName(), FocusPack.class.getName()),
	ID_EDGE(38400, EdgeParse.class.getName(), FocusPack.class.getName()),
	ID_MONDEO(38400, MondeoParse.class.getName(), FocusPack.class.getName()),
	ID_SIMPLE_DASAUTO1(38400, DasAuto1Parse.class.getName(), DasAuto1Pack.class.getName()),
	ID_SIMPLE_DASAUTO2(38400, DasAuto2Parse.class.getName(), DasAuto2Pack.class.getName()),
	ID_PRETTYSS(19200, PrettySSParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_PRETTYSS1(19200, PrettySSParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_XPXTL(38400, XTLParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_SIMPLE_TOYOT1(38400, TOYOT1Parse.class.getName(), Toyot1Pack.class.getName()),
	ID_XP_HONDA(38400, XHondaParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_XB_MAZDA(38400, MazdaParse.class.getName(), XinbasMazdaPack.class.getName()),
	ID_XP_GM(38400, XGMParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_HIWORLD_HARVARDH6(38400, HarvardH6Parse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_HIWORLD_HARVARD_COUPE(38400, HarvardCoupeParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_XP_PSA(38400, XPsaParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_HIWORLD_TRUMPCHI(38400, TrumpchiParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_BAOJUN(38400, BaoJunParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_XP_MAZDA(38400, SMazdaParse.class.getName(), SimpleMazdaPack.class.getName()),
	ID_RZ_GEELY(38400, GeelyParse.class.getName(), SimpleBaseComPack.class.getName()),
	ID_HIWORLD_MAZDA(38400, HwMazdaParse.class.getName(), HwMazdaPack.class.getName()),
	ID_HIWORLD_PRADO(38400, ToyotaPradoParse.class.getName(), ToyotaPradoPack.class.getName())
	;
	
	
	private int baudRate;
	
	private String parseClassName;
	
	private String packClassName;
	
	private ProtocolID(int baudRate, String parseClassName, String packClassName){
		
		this.baudRate = baudRate;
		this.parseClassName = parseClassName;
		this.packClassName = packClassName;
	}
	
	public String getParseClassName(){
		
		return parseClassName;
	}
	
	public String getPackClassName(){
		
		return packClassName;
	}
	
	public int getBaudRate(){
		
		return baudRate;
	}
	
}

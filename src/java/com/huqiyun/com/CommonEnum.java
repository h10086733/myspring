package com.huqiyun.com;

import java.util.HashMap;
import java.util.Map;

public class CommonEnum {
	public static Map<String, String> hm = new HashMap<String, String>();
	public static Map<String, String> hmName = new HashMap<String, String>();
	static {
		// 军工
		String jungong = "sz000519,sz000547,sz000561,sz000733,sz000738,sz000748,sz000768,sz000801,sz000901,sz002013,sz002023,sz002025,sz002049,sz002111,sz002151,sz002179,sz002214,sz002253,sz002260,sz002268,sz002338,sz002368,sz002413,sz002414,sz002465,sz002519,sz002544,sz300008,sz300034,sz300045,sz300053,sz300065,sz300101,sz300114,sz300123,sz300159,sz300177,sz300252,sz300324,sz300354,sz300447,sz300474,sh600038,sh600118,sh600150,sh600151,sh600184,sh600316,sh600343,sh600372,sh600391,sh600435,sh600480,sh600501,sh600523,sh600562,sh600677,sh600685,sh600765,sh600855,sh600879,sh600893,sh600967,sh600990,sh601989,sh603678";
		hm.put("jg", jungong);
		// 新能车
		String xinnengche = "000400, 000541, 000559, 000762, 000868, 000957, 002012, 002056, 002070, 002074, 002091, 002108, 002176, 002179, 002196, 002227, 002245, 002249, 002276, 002284, 002335, 002340, 002358, 002364, 002389, 002407, 002418, 002454, 002460, 002466, 002484, 002518, 002533, 002580, 002594, 002600, 002664, 002709, 300001, 300014, 300037, 300048, 300073, 300100, 300124, 300141, 300198, 300207, 300224, 300376, 300491, 600006, 600066, 600114, 600151, 600166, 600220, 600237, 600366, 600386, 600405, 600418, 600478, 600482, 600563, 600580, 600680, 600686, 600699, 600773, 600846, 600869, 600884, 601126, 601311, 601777, 603766, 603799";
		hm.put("xnc", xinnengche);
		// 中证汽车
		String zzqiche = "000025, 000559, 000572, 000581, 000599, 000625, 000700, 000753, 000757, 000760, 000800, 000868, 000957, 000980, 000996, 001696, 002031, 002048, 002085, 002126, 002190, 002213, 002239, 002265, 002283, 002284, 002328, 002355, 002363, 002406, 002434, 002448, 002454, 002472, 002488, 002510, 002536, 002537, 002553, 002590, 002592, 002593, 002594, 002602, 002607, 002625, 002662, 002664, 002703, 002708, 002765, 300022, 300100, 300304, 300432, 300473, 300507, 600006, 600066, 600081, 600104, 600148, 600166, 600178, 600297, 600303, 600335, 600386, 600418, 600480, 600523, 600623, 600653, 600660, 600676, 600686, 600699, 600741, 600742, 600877, 600960, 601058, 601127, 601258, 601311, 601633, 601689, 601777, 601799, 601966, 603023, 603701, 603766, 603997";
		hm.put("zzqc", zzqiche);
		// 中证传媒
		String zzchuanmei = "000156, 000503, 000681, 000793, 000839, 000917, 002027, 002095, 002123, 002131, 002174, 002195, 002261, 002343, 002354, 002400, 002439, 002517, 002555, 002624, 002739, 300017, 300027, 300058, 300059, 300104, 300113, 300133, 300251, 300291, 300315, 300336, 300359, 300364, 300383, 300418, 300431, 600037, 600373, 600633, 600637, 600715, 600804, 600959, 600986, 601098, 601801, 601928, 601929, 603000";
		hm.put("zzcm", zzchuanmei);
		// 移动互联
		String yidonghulian = "000050, 000555, 000558, 000793, 000829, 000861, 000887, 000901, 000977, 000988, 000997, 002008, 002024, 002055, 002065, 002131, 002153, 002174, 002195, 002223, 002230, 002241, 002261, 002266, 002268, 002273, 002279, 002284, 002308, 002325, 002326, 002344, 002373, 002405, 002414, 002416, 002429, 002439, 002444, 002446, 002456, 002467, 002477, 002488, 002491, 002642, 002701, 002707, 002739, 300003, 300010, 300015, 300017, 300088, 300098, 300100, 300113, 300133, 300136, 300166, 300168, 300178, 300188, 300212, 300222, 300229, 300253, 300271, 300273, 300287, 300291, 300296, 300302, 300336, 300359, 300367, 300369, 300392, 300458, 600037, 600074, 600158, 600270, 600271, 600335, 600373, 600487, 600498, 600570, 600588, 600699, 600703, 600718, 600804, 600845, 600978, 600998, 601098, 601801, 603000";
		hm.put("ydhl", yidonghulian);
		// 创业成长
		String cycz = "000005, 000018, 000034, 000036, 000150, 000546, 000796, 000836, 000928, 000957, 002019, 002027, 002036, 002071, 002074, 002085, 002099, 002107, 002169, 002172, 002174, 002179, 002180, 002202, 002221, 002252, 002270, 002314, 002323, 002354, 002357, 002373, 002411, 002415, 002426, 002450, 002460, 002466, 002475, 002504, 002508, 002517, 002555, 002572, 002573, 002579, 002581, 002594, 002602, 002624, 002635, 002640, 002643, 002709, 002714, 300017, 300023, 300032, 300033, 300059, 300072, 300085, 300100, 300104, 300113, 300115, 300118, 300131, 300136, 300144, 300156, 300182, 300199, 300207, 300208, 300219, 300237, 300252, 300253, 300267, 300292, 300296, 300302, 300317, 300319, 300324, 300367, 300376, 300431, 300450, 300484, 300498, 600093, 600113, 600131, 600273, 600779, 600856, 600891, 603006";
		hm.put("cycz", cycz);
		// 工业4.0
		String gy40 = "000821, 000961, 000988, 000997, 002008, 002009, 002073, 002161, 002184, 002185, 002224, 002230, 002232, 002367, 002380, 002426, 002472, 002527, 002529, 002559, 002577, 002698, 002721, 002747, 300024, 300034, 300048, 300076, 300097, 300115, 300124, 300161, 300170, 300171, 300173, 300221, 300223, 300293, 300337, 300358, 300367, 300400, 600172, 600588, 600699, 600765, 600835, 600845";
		hm.put("gy4.0", gy40);
		// 申万证券
		String swzq = "000166, 000686, 000712, 000728, 000750, 000776, 000783, 002500, 002673, 002736, 002797, 600030, 600061, 600109, 600369, 600837, 600958, 600999, 601099, 601198, 601211, 601377, 601555, 601688, 601788, 601901";
		hm.put("swzq", swzq);
		// 申万电子
		String swdz = "000049, 000050, 000413, 000536, 000541, 000636, 000725, 000727, 000988, 002005, 002008, 002025, 002036, 002049, 002055, 002056, 002079, 002106, 002129, 002137, 002138, 002141, 002156, 002161, 002179, 002180, 002185, 002188, 002217, 002241, 002273, 002288, 002371, 002384, 002389, 002402, 002414, 002436, 002456, 002463, 002475, 002484, 002547, 002618, 002635, 002636, 002638, 002782, 300032, 300053, 300077, 300078, 300083, 300088, 300115, 300128, 300131, 300136, 300162, 300183, 300207, 300219, 300256, 300269, 300296, 300317, 300322, 300373, 300408, 300433, 300438, 300458, 300476, 300502, 300516, 600074, 600171, 600183, 600360, 600363, 600460, 600563, 600584, 600651, 600666, 600667, 600703, 600707, 601231, 603005, 603328, 603989";
		hm.put("swdz", swdz);
		// 申万高铁
		String swgt = "000008, 000796, 000925, 002122, 002152, 002161, 002296, 002376, 002421, 002480, 002501, 300001, 300011, 300041, 300044, 300177, 300213, 300351, 300367, 300411, 300440, 300455, 300462, 600169, 600219, 600458, 600495, 600528, 600580, 600820, 600967, 601002, 601186, 601390, 601668, 601766, 601800, 603111, 603508";
		hm.put("swgt", swgt);
		
		
		// 军工
		hmName.put("jg", "军工");
		// 新能车
		hmName.put("xnc", "新能车");
		// 中证汽车
		hmName.put("zzqc", "中证汽车");
		// 中证传媒
		hmName.put("zzcm", "中证传媒");
		// 移动互联
		hmName.put("ydhl", "移动互联");
		// 创业成长
		hmName.put("cycz", "创业成长");
		// 工业4.0
		hmName.put("gy4.0", "工业4.0");
		// 申万证券
		hmName.put("swzq", "申万证券");
		// 申万电子
		hmName.put("swdz", "申万电子");
		// 申万高铁
		hmName.put("swgt", "申万高铁");
	}
}

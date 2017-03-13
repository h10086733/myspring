package com.huqiyun.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CommonEnum {
	//行业  和 行业个股代码
	public static Map<String, String> hm = new TreeMap<String, String>();
	//行业 个股总数
	public static Map<String, Integer> hmCount = new HashMap<String, Integer>();
	//行业名称
	public static Map<String, String> hmName = new HashMap<String, String>();
	//行业代码
	public static Map<String, String> hmCode = new TreeMap<String, String>();
	static {
		// 军工
		String jungong = "sz000519,sz000547,sz000561,sz000733,sz000738,sz000748,sz000768,sz000801,sz000901,sz002013,sz002023,sz002025,sz002049,sz002111,sz002151,sz002179,sz002214,sz002253,sz002260,sz002268,sz002338,sz002368,sz002413,sz002414,sz002465,sz002519,sz002544,sz300008,sz300034,sz300045,sz300053,sz300065,sz300101,sz300114,sz300123,sz300159,sz300177,sz300252,sz300324,sz300354,sz300447,sz300474,sh600038,sh600118,sh600150,sh600151,sh600184,sh600316,sh600343,sh600372,sh600391,sh600435,sh600480,sh600501,sh600523,sh600562,sh600677,sh600685,sh600765,sh600855,sh600879,sh600893,sh600967,sh600990,sh601989,sh603678";
		hm.put("jg", jungong);
		// 新能车
		String xinnengche = "000400, 000541, 000559, 000762, 000868, 000957, 002012, 002056, 002070, 002074, 002091, 002108, 002176, 002179, 002196, 002227, 002245, 002249, 002276, 002284, 002335, 002340, 002358, 002364, 002389, 002407, 002418, 002454, 002460, 002466, 002484, 002518, 002533, 002580, 002594, 002600, 002664, 002709, 300001, 300014, 300037, 300048, 300073, 300100, 300124, 300141, 300198, 300207, 300224, 300376, 300491, 600006, 600066, 600114, 600151, 600166, 600220, 600237, 600366, 600386, 600405, 600418, 600478, 600482, 600563, 600580, 600680, 600686, 600699, 600773, 600846, 600869, 600884, 601126, 601311, 601777, 603766, 603799";
		hm.put("xnc", xinnengche);
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
		// 中证白酒
		String zzbj = "000568, 000596, 000799, 000858, 000860, 002304, 002646, 600197, 600199, 600519, 600559, 600702, 600779, 600809, 603198, 603589";
		hm.put("zzbj", zzbj);
		//申万钢铁
		String gangtie="000708, 000709, 000717, 000761, 000778, 000825, 000898, 000906, 000932, 000959, 002075, 002110, 002318, 002443, 002478, 002756, 600005, 600010, 600019, 600022, 600117, 600126, 600231, 600282, 600307, 600399, 600507, 600569, 600581, 600608, 600782, 600784, 600808, 601003, 601005";
		hm.put("gangtie", gangtie);
		//中证煤炭
		String zzmt="000552, 000571, 000723, 000780, 000937, 000983, 002128, 600121, 600123, 600157, 600188, 600348, 600395, 600397, 600508, 600714, 600740, 600792, 600971, 600997, 601001, 601011, 601015, 601088, 601101, 601225, 601666, 601699, 601898";
		hm.put("zzmt", zzmt);
		//申万有色金属
		String swysjs="000008, 000060, 000426, 000511, 000519, 000603, 000612, 000630, 000633, 000657, 000688, 000693, 000697, 000751, 000758, 000795, 000807, 000813, 000831, 000878, 000933, 000960, 000962, 000969, 000970, 000975, 002057, 002114, 002130, 002149, 002155, 002160, 002167, 002171, 002182, 002203, 002237, 002295, 002340, 002378, 002379, 002428, 002460, 002466, 002501, 002540, 002578, 002600, 002716, 002806, 300127, 300224, 300337, 300395, 300428, 300489, 600111, 600114, 600139, 600206, 600219, 600255, 600259, 600311, 600330, 600331, 600338, 600362, 600366, 600385, 600390, 600392, 600432, 600456, 600459, 600478, 600489, 600490, 600497, 600516, 600531, 600547, 600549, 600595, 600614, 600615, 600673, 600687, 600711, 600766, 600768, 600888, 600961, 600980, 600988, 601020, 601069, 601137, 601168, 601388, 601600, 601677, 601899, 601958, 603399, 603663, 603688, 603799, 603993";
		hm.put("swysjs", swysjs);
		//一带一路
		String ydyl="000018, 000063, 000065, 000157, 000400, 000425, 000777, 000877, 000905, 000928, 002051, 002092, 002202, 002266, 002307, 002353, 002524, 002531, 002554, 002606, 002738, 300001, 300011, 300103, 300208, 300351, 600017, 600018, 600026, 600028, 600031, 600068, 600089, 600118, 600125, 600150, 600256, 600279, 600312, 600320, 600368, 600406, 600425, 600428, 600487, 600495, 600522, 600528, 600545, 600580, 600583, 600717, 600759, 600798, 600820, 600875, 600970, 601002, 601018, 601117, 601179, 601186, 601390, 601618, 601668, 601669, 601727, 601766, 601800, 601808, 601857, 601866, 601872, 601880, 601989, 603111, 603308, 603338";
		hm.put("ydyl", ydyl);
		//智能家居
		String znjj="000021, 000063, 000066, 000100, 000156, 000333, 000418, 000503, 000651, 000810, 000829, 000938, 000977, 000988, 000997, 002008, 002024, 002049, 002055, 002065, 002104, 002121, 002185, 002217, 002230, 002236, 002241, 002242, 002261, 002268, 002273, 002280, 002281, 002284, 002308, 002364, 002368, 002405, 002414, 002415, 002421, 002429, 002439, 002446, 002467, 002475, 002491, 002508, 002512, 002519, 002544, 002577, 002583, 002631, 002642, 002657, 002681, 300002, 300010, 300020, 300024, 300078, 300079, 300098, 300104, 300113, 300166, 300168, 300188, 300212, 300253, 300273, 300288, 300297, 300302, 300359, 300367, 300369, 600060, 600074, 600100, 600183, 600198, 600271, 600372, 600410, 600536, 600584, 600588, 600637, 600654, 600690, 600699, 600718, 600728, 600804, 600839, 600850, 600879, 601231";
		hm.put("znjj", znjj);
		//医药生物
		String yysw="000004, 000028, 000078, 000150, 000153, 000403, 000411, 000423, 000503, 000513, 000518, 000538, 000566, 000590, 000597, 000606, 000623, 000650, 000661, 000705, 000739, 000756, 000766, 000788, 000790, 000908, 000915, 000919, 000952, 000963, 000989, 000990, 000999, 002001, 002007, 002019, 002020, 002022, 002030, 002038, 002044, 002099, 002107, 002118, 002166, 002198, 002219, 002223, 002252, 002262, 002275, 002287, 002294, 002317, 002332, 002349, 002365, 002370, 002390, 002393, 002399, 002411, 002412, 002422, 002424, 002432, 002433, 002437, 002462, 002550, 002551, 002566, 002581, 002589, 002603, 002626, 002644, 002653, 002675, 002680, 002693, 002727, 002728, 002737, 002750, 002758, 002773, 002788, 002817, 002821, 300003, 300006, 300009, 300015, 300016, 300026, 300030, 300039, 300049, 300086, 300110, 300122, 300142, 300147, 300158, 300171, 300181, 300194, 300199, 300204, 300206, 300216, 300233, 300238, 300239, 300244, 300246, 300254, 300255, 300261, 300267, 300273, 300289, 300294, 300298, 300314, 300318, 300326, 300347, 300357, 300358, 300363, 300381, 300396, 300401, 300404, 300406, 300412, 300436, 300439, 300452, 300453, 300463, 300482, 300485, 300497, 300519, 300529, 300534, 300558, 300562, 300573, 600055, 600056, 600062, 600079, 600080, 600085, 600129, 600161, 600196, 600211, 600216, 600222, 600252, 600267, 600272, 600276, 600285, 600329, 600332, 600351, 600380, 600420, 600422, 600436, 600479, 600488, 600511, 600513, 600518, 600521, 600529, 600530, 600535, 600557, 600566, 600572, 600587, 600594, 600613, 600645, 600664, 600671, 600713, 600721, 600750, 600763, 600767, 600771, 600781, 600789, 600796, 600812, 600829, 600833, 600851, 600867, 600976, 600993, 600998, 601607, 603108, 603168, 603222, 603309, 603368, 603456, 603520, 603567, 603658, 603669, 603716, 603858, 603883, 603939, 603987, 603998";
		hm.put("yysw", yysw);
		//人工智能
		String rgzn="000055, 000058, 000066, 000070, 000821, 000977, 000988, 000997, 002011, 002048, 002049, 002063, 002073, 002079, 002095, 002151, 002156, 002161, 002184, 002185, 002226, 002230, 002232, 002236, 002241, 002253, 002284, 002331, 002348, 002362, 002373, 002405, 002414, 002415, 002439, 002446, 002452, 002583, 002642, 300005, 300017, 300024, 300036, 300044, 300077, 300078, 300104, 300166, 300182, 300188, 300209, 300212, 300222, 300223, 300229, 300231, 300245, 300250, 300302, 300307, 300322, 300353, 300358, 300367, 300400, 300418, 300474, 300520, 600171, 600198, 600288, 600360, 600410, 600460, 600525, 600584, 600588, 600640, 600667, 600699, 600718, 600728, 600756, 600770, 600797, 600848, 600895, 603019";
		hm.put("rgzn", rgzn);
		//电器设备
		String dqsb="000400, 000585, 000591, 000682, 000806, 000922, 000967, 002028, 002058, 002074, 002090, 002112, 002121, 002123, 002168, 002169, 002176, 002184, 002196, 002202, 002212, 002218, 002227, 002249, 002255, 002266, 002276, 002298, 002300, 002309, 002322, 002334, 002335, 002339, 002350, 002356, 002358, 002359, 002364, 002441, 002451, 002452, 002471, 002498, 002506, 002518, 002527, 002531, 002533, 002534, 002546, 002560, 002576, 002580, 002606, 002610, 002617, 002622, 002630, 002665, 002692, 002706, 002733, 002767, 002801, 002823, 300001, 300011, 300018, 300029, 300040, 300048, 300062, 300068, 300069, 300105, 300111, 300118, 300120, 300124, 300129, 300140, 300141, 300153, 300208, 300215, 300222, 300265, 300274, 300283, 300286, 300308, 300316, 300341, 300356, 300360, 300370, 300376, 300393, 300407, 300414, 300423, 300427, 300444, 300447, 300466, 300477, 300484, 300490, 300491, 300510, 300569, 600089, 600110, 600112, 600151, 600192, 600202, 600268, 600290, 600312, 600353, 600379, 600401, 600405, 600406, 600416, 600468, 600475, 600517, 600525, 600537, 600550, 600580, 600590, 600847, 600869, 600875, 600885, 600973, 601012, 601126, 601179, 601218, 601222, 601558, 601567, 601616, 601700, 601727, 601877, 601908, 603015, 603016, 603025, 603100, 603333, 603606, 603618, 603806, 603819, 603859, 603861, 603988";
		hm.put("dqsb", dqsb);
		//沪深300
		String hs300 = "000001, 000002, 000008, 000009, 000027, 000039, 000060, 000061, 000063, 000069, 000100, 000156, 000157, 000166, 000333, 000338, 000402, 000413, 000415, 000423, 000425, 000503, 000538, 000540, 000555, 000559, 000568, 000623, 000625, 000627, 000630, 000651, 000671, 000686, 000709, 000712, 000718, 000725, 000728, 000738, 000750, 000768, 000776, 000778, 000783, 000792, 000793, 000800, 000826, 000839, 000858, 000876, 000895, 000917, 000938, 000963, 000977, 000983, 001979, 002007, 002008, 002024, 002027, 002049, 002065, 002074, 002081, 002085, 002129, 002131, 002142, 002146, 002152, 002153, 002174, 002183, 002195, 002202, 002230, 002236, 002241, 002252, 002292, 002299, 002304, 002310, 002385, 002415, 002424, 002426, 002450, 002456, 002465, 002466, 002470, 002475, 002500, 002568, 002594, 002673, 002714, 002736, 002739, 002797, 300002, 300015, 300017, 300024, 300027, 300033, 300058, 300059, 300070, 300072, 300085, 300104, 300124, 300133, 300144, 300146, 300168, 300182, 300251, 300315, 600000, 600008, 600009, 600010, 600015, 600016, 600018, 600019, 600021, 600023, 600028, 600029, 600030, 600031, 600036, 600037, 600038, 600048, 600050, 600060, 600061, 600066, 600068, 600074, 600085, 600089, 600100, 600104, 600109, 600111, 600115, 600118, 600150, 600153, 600157, 600170, 600177, 600188, 600196, 600208, 600221, 600252, 600256, 600271, 600276, 600297, 600309, 600332, 600340, 600352, 600362, 600369, 600372, 600373, 600376, 600383, 600406, 600415, 600446, 600482, 600485, 600489, 600498, 600518, 600519, 600535, 600547, 600549, 600570, 600582, 600583, 600585, 600588, 600606, 600637, 600648, 600649, 600654, 600660, 600663, 600666, 600674, 600685, 600688, 600690, 600703, 600704, 600705, 600718, 600737, 600739, 600741, 600754, 600783, 600795, 600804, 600816, 600820, 600827, 600837, 600839, 600867, 600871, 600873, 600875, 600886, 600887, 600893, 600895, 600900, 600958, 600959, 600999, 601006, 601009, 601018, 601021, 601088, 601099, 601111, 601118, 601127, 601155, 601166, 601169, 601186, 601198, 601211, 601216, 601225, 601258, 601288, 601318, 601328, 601333, 601336, 601377, 601390, 601398, 601555, 601600, 601601, 601607, 601608, 601611, 601618, 601628, 601633, 601668, 601669, 601688, 601718, 601727, 601766, 601788, 601800, 601818, 601857, 601866, 601872, 601877, 601888, 601899, 601901, 601919, 601928, 601933, 601939, 601958, 601985, 601988, 601989, 601998, 603000, 603885, 603993";
		hm.put("hs300", hs300);
		//中证500
		String zz500 = "000006, 000012, 000021, 000025, 000028, 000031, 000049, 000050, 000062, 000066, 000078, 000089, 000090, 000099, 000158, 000400, 000401, 000417, 000418, 000426, 000488, 000501, 000513, 000517, 000519, 000528, 000541, 000543, 000547, 000552, 000563, 000566, 000572, 000581, 000587, 000592, 000596, 000598, 000600, 000612, 000616, 000620, 000631, 000636, 000652, 000656, 000661, 000667, 000669, 000680, 000681, 000685, 000690, 000697, 000703, 000723, 000726, 000727, 000758, 000761, 000762, 000777, 000786, 000806, 000810, 000816, 000825, 000829, 000830, 000848, 000860, 000861, 000869, 000877, 000878, 000897, 000919, 000926, 000930, 000931, 000937, 000939, 000959, 000960, 000961, 000969, 000970, 000973, 000975, 000979, 000988, 000997, 000998, 000999, 001696, 002001, 002002, 002004, 002005, 002011, 002013, 002018, 002019, 002022, 002025, 002028, 002029, 002030, 002038, 002041, 002048, 002050, 002051, 002056, 002063, 002064, 002073, 002078, 002092, 002093, 002106, 002118, 002122, 002123, 002128, 002155, 002161, 002168, 002176, 002179, 002190, 002191, 002194, 002217, 002221, 002223, 002233, 002238, 002242, 002244, 002249, 002250, 002251, 002254, 002261, 002266, 002268, 002269, 002271, 002273, 002276, 002277, 002281, 002285, 002308, 002309, 002311, 002315, 002317, 002325, 002327, 002332, 002340, 002342, 002344, 002345, 002353, 002354, 002358, 002366, 002368, 002371, 002373, 002375, 002384, 002390, 002392, 002396, 002399, 002400, 002405, 002407, 002408, 002410, 002414, 002416, 002422, 002428, 002431, 002437, 002439, 002440, 002444, 002460, 002463, 002477, 002479, 002482, 002489, 002491, 002498, 002503, 002505, 002508, 002512, 002544, 002551, 002572, 002573, 002581, 002588, 002589, 002595, 002602, 002603, 002635, 002640, 002642, 002646, 002657, 002663, 002665, 002670, 002672, 002681, 002690, 002698, 002699, 002701, 002707, 002727, 002745, 300001, 300010, 300026, 300032, 300039, 300043, 300055, 300088, 300113, 300115, 300122, 300134, 300136, 300147, 300156, 300159, 300166, 300199, 300202, 300244, 300253, 300257, 300266, 300273, 300274, 300287, 300291, 300296, 300297, 300324, 600006, 600017, 600022, 600026, 600039, 600053, 600056, 600058, 600059, 600062, 600064, 600067, 600073, 600079, 600086, 600088, 600094, 600098, 600108, 600112, 600120, 600122, 600125, 600138, 600141, 600143, 600151, 600158, 600160, 600161, 600166, 600169, 600171, 600175, 600176, 600180, 600183, 600184, 600187, 600195, 600198, 600200, 600201, 600216, 600219, 600220, 600240, 600251, 600259, 600260, 600266, 600267, 600270, 600277, 600280, 600282, 600284, 600289, 600291, 600292, 600298, 600300, 600307, 600312, 600315, 600316, 600325, 600329, 600335, 600338, 600348, 600351, 600366, 600380, 600388, 600392, 600395, 600397, 600409, 600410, 600416, 600418, 600422, 600425, 600426, 600428, 600433, 600435, 600436, 600458, 600460, 600466, 600468, 600478, 600481, 600483, 600487, 600496, 600497, 600499, 600500, 600503, 600511, 600516, 600517, 600521, 600522, 600525, 600528, 600536, 600537, 600545, 600551, 600557, 600563, 600565, 600572, 600575, 600580, 600584, 600586, 600587, 600594, 600596, 600597, 600600, 600601, 600611, 600614, 600618, 600628, 600633, 600635, 600639, 600640, 600643, 600645, 600651, 600655, 600657, 600664, 600673, 600682, 600687, 600694, 600699, 600717, 600720, 600729, 600736, 600743, 600748, 600750, 600751, 600755, 600757, 600759, 600765, 600770, 600773, 600776, 600787, 600790, 600801, 600805, 600808, 600809, 600811, 600823, 600825, 600826, 600831, 600835, 600848, 600850, 600851, 600859, 600862, 600863, 600864, 600869, 600872, 600874, 600879, 600880, 600881, 600884, 600894, 600917, 600967, 600970, 600971, 600978, 600981, 600993, 601000, 601001, 601002, 601010, 601012, 601016, 601168, 601231, 601233, 601311, 601678, 601689, 601699, 601717, 601777, 601801, 601880, 601886, 601908, 601929, 603001, 603005, 603019, 603025, 603077, 603169, 603188, 603198, 603328, 603355, 603369, 603377, 603528, 603555, 603567, 603568, 603589, 603698, 603766, 603806, 603866, 603868, 603883";
		hm.put("zz500", zz500);
		
		
		//板块个数
		for (Entry<String, String> set:hm.entrySet()) {
			hmCount.put(set.getKey(), set.getValue().split(",").length);
		}
		
		// 军工
		hmName.put("jg", "军工");
		// 新能车
		hmName.put("xnc", "新能车");
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
		// 中证白酒
		hmName.put("zzbj", "中证白酒");
		//申万钢铁
		hmName.put("gangtie", "申万钢铁");
		//中证煤炭
		hmName.put("zzmt", "中证煤炭");
		//申万有色金属
		hmName.put("swysjs", "申万有色金属");
		//一带一路
		hmName.put("ydyl", "一带一路");
		//智能家居
		hmName.put("znjj", "智能家居");
		//医药生物
		hmName.put("yysw", "医药生物");
		//人工智能
		hmName.put("rgzn", "人工智能");
		//电气设备
		hmName.put("dqsb", "电气设备");
		
		//沪深300
		hmName.put("hs300", "沪深300");
		//中证500
		hmName.put("zz500", "中证500");
		//中证1000
		hmName.put("zz1000", "中证1000");
		//中证全指
//		hmName.put("zzqz", "中证全指");
		
		hmCode.put("swysjs", "399395");//国证有色
		hmCode.put("swgt", "399419");//国证高铁
		hmCode.put("gangtie", "399440");//国证钢铁
		hmCode.put("swzq", "399707");//CSSW证券
		hmCode.put("zzcm", "399810");//CSSW传媒
		hmCode.put("swdz", "399811");//CSSW电子
		hmCode.put("xnc", "399976");//CS新能车
		hmCode.put("ydyl", "399991");//一带一路
		hmCode.put("zzmt", "399998");//中证煤炭
		hmCode.put("jg", "399967");//中证军工
		hmCode.put("ydhl", "399970");//移动互联
		hmCode.put("zzbj", "399997");//中证白酒
//		hmCode.put("gqgg", "399974");//国企改革
		hmCode.put("cycz", "399958");//创业成长
//		hmCode.put("zzqz", "sh000985");//中证全指
		hmCode.put("hs300", "sh000300");//沪深300
		hmCode.put("zz500", "sh000905");//中证500
		hmCode.put("hs300", "sh000300");//沪深300
		hmCode.put("zz1000", "sh000852");//中证1000
		
		
	}
	public static void main(String[] args) {
		for(Entry<String, Integer> s:hmCount.entrySet()){
			System.out.print("'"+s.getKey()+"':'"+s.getValue()+"',");
		}
//		System.out.println(hmCount.toString());
		
	}
}

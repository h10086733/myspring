package com.huqiyun.com;

/**
 * 
 * @author huqiyun
 *
 */
public class SqlName {

	/**
	 * 命名空间分隔符
	 */
	private static final String SEPARATOR = ".";

	/**
	 * 命名空间：系统公共sql
	 */
	private static final String COMMON_NAMESPACE = "common" + SEPARATOR;

	/**
	 * 查询uuid
	 */
	public static final String QUERY_UUID = COMMON_NAMESPACE + "queryUUID";

	// 板块关联的股票
	public class CBankuaiSql {

		private static final String namespace = "cBankuai" + SEPARATOR;

		public static final String insert = namespace + "insert";

		public static final String update = namespace + "update";

		public static final String updateForce = namespace + "updateForce";

		public static final String queryList = namespace + "queryList";

		public static final String queryListCount = namespace + "queryListCount";

		public static final String loadById = namespace + "loadById";

		public static final String delete = namespace + "delete";
	}

	// 大盘数据
	public class CdapanSql {

		private static final String namespace = "cdapan" + SEPARATOR;

		public static final String insert = namespace + "insert";

		public static final String update = namespace + "update";

		public static final String updateForce = namespace + "updateForce";

		public static final String queryList = namespace + "queryList";

		public static final String queryListCount = namespace + "queryListCount";

		public static final String loadById = namespace + "loadById";

		public static final String delete = namespace + "delete";
	}
	//板块系数
	public class CBankuaiXishuSql{
			
			private static final String namespace = "cBankuaiXishu"+SEPARATOR;
			
			public static final String insert = namespace+"insert";
			
			public static final String update = namespace+"update";
			
			public static final String updateForce = namespace+"updateForce";
			
			public static final String queryList = namespace+"queryList";
			
			public static final String queryListCount = namespace+"queryListCount";
			
			public static final String loadById = namespace+"loadById";
			
			public static final String delete = namespace+"delete";
	}
}

/**
 * 
 */
package com.coderme;

/**
 * @author zhang tengfei
 * 2014-8-13
 */
public class Constants {

	/**
	 * 调用健康服务的地址
	 */
	public static final String HEALTH_SERVICE="health.service";
	
	public static enum PermissionType {
        menu("菜单"), button("按钮");

        private final String info;
        private PermissionType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
        
        public static String getByEneu(String eneu) {
        	if (eneu.equals(menu.toString())) {
        		return menu.getInfo();
        	} else if (eneu.equals(button.toString())) {
        		return button.getInfo();
        	} else {
        		return null;
        	}
        }
    }
	
	/**
	 * 性别
	 * 0：女 
	 * 1：男
	 * 2：不区分
	 * @author zhang tengfei
	 * 2014-9-24
	 */
	public static enum Sex {
		FAMALE(0), MALE(1), IGNORE(2);
		
		private Integer value;
		
		private Sex(Integer value){
			this.setValue(value);
		}

		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
	}
	/**
	 * 类型 1:疾病 2:风险
	 * @author zhang tengfei
	 * 2014-9-24
	 */
	public static enum InterpretationType{
		DIEASE(1), RISK(2);
		
		private Integer value;
		
		private InterpretationType(Integer value){
			this.setValue(value);
		}

		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
	}
}

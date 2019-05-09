package org.model;

public class Author {
		// Fields
		private Integer id;
		private String name;
		private String birthplace;
		private String describe;
		
		// Constructors

		/** default constructor */
		public Author() {
		}

		/** full constructor */
		public Author(String name, String birthplace) {
			this.name = name;
			this.birthplace = birthplace;
		}

		// Property accessors

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBirthplace() {
			return this.birthplace;
		}

		public void setBirthplace(String birthplace) {
			this.birthplace = birthplace;
		}
		
		public String getDescribe() {
			return describe;
		}
		
		public void setDescribe(String describe) {
			this.describe = describe;
		}
}

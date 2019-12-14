package com.demo.crud.crudservice.constants;

public class Constants {

	  public static final String SQL_SELECT="SELECT ID,NAME FROM NOTES";
		public static final String SQL_CREATE="INSERT INTO NOTES  VALUES (?,?)";
		public static final String SQL_UPDATE="UPDATE NOTES SET NAME=?  WHERE ID=?";
		public static final String SQL_DELETE="DELETE  FROM NOTES WHERE ID=?";

}

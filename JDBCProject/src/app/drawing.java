package app;

public class drawing {

	/*-
	 
											                   	   +---------------------------+      +---------------------------+       +---------------------------------+                                
									                           	   |                           |      |                           |       |    Database Connectivity:       |
							+-------------------------+            | Services:                 |      |  Repository:              |       |                                 |
							|  Main Menu :            |            |                           |      |                           |       |        Settings                 |
							|                         |            |      IServicesnterface    |      |     IRepository           |       |                                 |
	+---------+             |   1. Add Submodule      |            |                           |      |                           |       |             For                 |    +-------------+
	|         |             |                         |            |        IStudentService    |      |        IRepositoryStudent |       |                                 |    |             |
	|         |             |   2. Find Submodule     |            |                           |      |                           |       |                Database         +---->    DATABASE |
	|         |             |                         +------------>        ITeacherService    +------>        IRepositoryTeacher +------->                                 |    |             |
	|         +------------->   3. Delete Submodule   |            |                           |      |                           |       |                   Connection    |    |     MySQL   |
	|  App    |             |                         |            |        IStaffService      |      |        IRepositoryStaff   |       |                                 |    +-------------+
	+---------+             |   4. Update Submodule   |            |                           |      |                           |       +---------------------------------+
	                    	+-------------------------+            +---------------------------+      +---------------------------+
	
	
	
	
	
	
	
	
								+-------------+                            +------------------------------------+                                +-------------------------+
								|             |                            |                                    |                                |                         |
								|  FRONTEND   |                            |   MIDDLE TIER = PROCESSING         |                                |   BACKEND  :  DATABASE  |
								|             |                            |                                    |                                |                         |
								+-------------+                            +------------------------------------+                                +-------------------------+
	
	
	*/

}

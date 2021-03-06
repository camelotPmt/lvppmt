package com.camelot.pmt.task.mapper;


import com.camelot.pmt.platform.utils.Pager;
import com.camelot.pmt.task.model.Task;
import com.camelot.pmt.task.model.TaskDetail;

import java.util.List;
import java.util.Map;

import com.camelot.pmt.task.model.TaskLog;
import org.apache.ibatis.annotations.Param;


public interface TaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
	
	/**
     * @author: zlh
     * @param:
     * @description: 查询所有任务列表
     * @date: 16:54 2018/4/9
     *//*
    List<TaskManager> queryAllTask();

    *//**
	 * @author: zlh
     * @param taskManager 模糊查询的条件
     * @description: 根据条件查询任务
     * @return
     *//*
    List<TaskManager> queryTaskByTask(TaskManager taskManager);

    *//**
     * @author: zlh
     * @param: taskManager 插入任务的数据
     * @description: 新增任务
     * @date: 9:07 2018/4/12
     *//*
    int insertTask(TaskManager taskManager);

    *//**
     * @author: zlh
     * @param: taskManager 需要修改的任务数据
     * @description: 根据任务id修改任务
     * @date: 10:18 2018/4/12
     *//*
    int updateTaskById(TaskManager taskManager);
*/
    /**
     * @author: zlh
     * @param: id 任务id
     * @description: 根据任务id查询任务详情
     * @date: 17:08 2018/4/12
     */
    //TaskManager queryTaskById(Long id);

    /**
     * @author: zlh
     * @param:  id 父id
     * @description: 根据父id查询所有的子任务id
     * @date: 16:04 2018/4/12
     */
    List<Long> querySubTaskIdByParantId(Long id);

    /**
     * @author: zlh
     * @param: id 需要删除的任务的id
     * @description: 根据任务删除id
     * @date: 17:22 2018/4/12
     */
    int deleteTaskById(Long id);

    /**
     * 查询延期任务个数
    * @Title: queryCount
    * @Description: TODO
    * @param @return
    * @return Long 
    * @throws
     */
	Long queryCount();
	/**
	 * 查询延期任务列表+分页+排序+时间正序+优先级倒序
	* @Title: queryOverdueTask
	* @Description: TODO
	* @param @param page
	* @param @return
	* @return List<Task> 
	* @throws
	 */
	 List<Task> queryOverdueTask(@Param(value = "page") Pager page);

	
	/**
	 * 
	* @Title: queryMyTaskTreeByTaskId 
	* @Description: TODO(查询taskId下的一级子节点) 
	* @param @param taskId taskType beassignUserId
	* @param @return    设定文件 
	* @return List<Task>    返回类型 
	* @throws
	 */
	List<Task> queryMyTaskListNodeByParentId(Long taskId,String taskType,Long beassignUserId);
	
	/**
	 * 
	* @Title: queryTaskListNodeByParentId 
	* @Description: TODO(查询taskId下的一级子节点) 
	* @param @param taskId taskType
	* @param @return    设定文件 
	* @return List<Task>    返回类型 
	* @throws
	 */
	List<Task> queryTaskListNodeByParentId(Long taskId,String taskType);
	
	/**
	 * 
	* @Title: queryAllTaskList 
	* @Description: TODO(查询整个任务表) 
	* @param @return    设定文件 
	* @return List<Task>    返回类型 
	* @throws
	 */
	List<Task> queryAllTaskList(String taskType,Long beassignUserId);
	
	/**
	 * 
	* @Title: queryTopTaskNameList 
	* @Description: TODO(查询顶级我的待办任务) 
	* @param @return    设定文件 
	* @return List<Task>    返回类型 
	* @throws
	 */
	List<Task> queryTopTaskNameList(String taskType,Long beassignUserId);
	
	/**
	 * 
	* @Title: updateTaskPendingToDelay
	* @Description: TODO(我的待办任务转为延期,会将该节点及节点下的所有子节点变为延期状态) 
	* @param @param taskId taskType
	* @param @return    设定文件 
	* @return JSONObject    返回类型 
	* @throws
	 */
	void updateTaskPendingToDelay(Long id,String taskType,String delayDescribe,String estimateStartTime);
	
	/**
	 * 
	* @Title: updateTaskPendingToRuning 
	* @Description: TODO(我的待办任务转为正在进行) 
	* @param @param taskId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	void updateTaskPendingToRuning(Long id,String taskType);
	
	/**
	 * 
	* @Title: updateTaskToAssign 
	* @Description: TODO(更新指派人和被指派人标识号) 
	* @param @param id
	* @param @param assignUserId
	* @param @param beassignUserId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	void updateTaskToAssign(Long id,Long assignUserId,Long beassignUserId);
	
	/**
	 * 
	* @Title: queryParentTaskNodeById 
	* @Description: TODO(查询根据任务Id查询父级任务对象) 
	* @param @param id
	* @param @return    设定文件 
	* @return Task    返回类型 
	* @throws
	 */
	Task queryParentTaskNodeById(Long id);










	/**
	 * 查询正在进行的任务，根据时间和优先级进行排序
	 * myp
	 * */
    List<Map<String,Object>> listTaskRunning(String id);


    /**
     *
     * */
    void runningtoclose(List<Long> alist);


    /**
     * 根据任务id查询所有的次id的子任务
     * myp
     * */
    List<Task> selectByPId(Long pid);





















	/**
	 * 根据id查询任务明细
	 * myp
	 * */
	Task selectTaskById(Long id);

	/**
	 * 查询已完成的任务，根据时间和优先级进行排序
	 * myp
	 * */
	List<Map<String,Object>> listTaskAlready(@Param(value = "page") Pager page, @Param(value = "id") Long id);



	/**
	 * 添加历史记录 @Title: queryCount @Description: TODO @param @return @return
	 * Long @throws
	 * myp
	 */
	Long saveHistoryLog(TaskLog taskLog);

	/**
	 *
	 * @Title: updateTaskPendingToDelay
	 * @Description: TODO(我的待办任务转为延期,会将该节点及节点下的所有子节点变为延期状态)
	 * @param @param taskId taskType
	 * @param @return    设定文件
	 * @return JSONObject    返回类型
	 * @throws
	 */
	void updateTaskAlreadyToRunning(Long id,String taskType,String delayDescribe,String estimateStartTime);

	/**
	 *
	 * @Title: updateTaskPendingToRuning
	 * @Description: TODO(我的待办任务转为正在进行)
	 * @param @param taskId
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	void updateTaskToClose(Long id,String taskType);

	/**
	 * 查询延期任务信息详情
	* @Title: queryOverdueTaskDetailByTaskId
	* @Description: TODO
	* @param @param taskId
	* @param @return
	* @return TaskDetail 
	* @throws
	 */
	TaskDetail queryOverdueTaskDetailByTaskId(String taskId);
	
	/**
	 * 添加延期信息与预定开始时间
	* @Title: insertOverduMessage
	* @Description: TODO
	* @param @param task
	* @param @return
	* @return Integer 
	* @throws
	 */
	Integer insertOverduMessage(Task task);
	
	/**
	 * 根据userId查询个人是否有延期任务
	* @Title: queryOverdueTaskUserId
	* @Description: TODO
	* @param @param userId
	* @param @return
	* @return int 
	* @throws
	 */
	int queryOverdueTaskUserId(String userId);
}
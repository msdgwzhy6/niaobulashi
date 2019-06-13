package com.niaobulashi.modules.sys.controller;

import com.niaobulashi.common.utils.PageUtils;
import com.niaobulashi.common.utils.ResponseVo;
import com.niaobulashi.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: niaobulashi
 * @description: 系统日志
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-13 21:19
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("sys:log:list")
	public ResponseVo list(@RequestParam Map<String, Object> params){
		PageUtils page = sysLogService.queryPage(params);

		return ResponseVo.ok().put("page", page);
	}
	
}

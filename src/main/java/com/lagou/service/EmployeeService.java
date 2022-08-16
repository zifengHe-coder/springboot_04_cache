package com.lagou.service;

import com.lagou.constants.CacheNameConstants;
import com.lagou.mapper.EmployeeMapper;
import com.lagou.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author hezifeng
 * @create 2022/8/15 18:13
 */
@Service
@CacheConfig(cacheNames = CacheNameConstants.EMPLOYEE)
public class EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    /**
     * @Cacheable 缓存查询，将该方法的查询结果存入缓存
     *    value/cacheNames 指定缓存名称，cacheManager是管理多个cache,以名称进行区分
     *    key 缓存数据时指定key值, (key,value)，默认是方法的参数值，也可以用spEL来计算key值
     *    keyGenerator： key的生成策略 和key二选一,用于自定义keyGenerator
     *    cacheManager: 指定缓存管理器 redis:emp,ehcache:emp
     *    cacheResolver: 功能和cacheManager二选一
     *    condition:条件属性，要满足该条件才会进行缓存
     *    unless:满足条件时不进行缓存
     *    sync:是否使用异步属性进行缓存
     *      (1） condition/unless 同时满足，不做缓存
     *      (2) sync=true unless不被支持
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#id", unless = "#result == null")
    public Employee getEmpById(Integer id) {
        return mapper.getEmpById(id);
    }

    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee) {
        mapper.updateEmp(employee);
        return employee;
    }

    @CachePut(key = "#result.id")
    public Employee insertEmp(Employee employee) {
        mapper.insertEmp(employee);
        return employee;
    }

    @CacheEvict(key = "#id", beforeInvocation = true)
    public void delEmp(Integer id) {
        mapper.deleteEmp(id);
    }
}

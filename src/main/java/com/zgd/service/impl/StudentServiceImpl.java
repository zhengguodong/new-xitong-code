package com.zgd.service.impl;

import com.zgd.entity.Student;
import com.zgd.mapper.StudentMapper;
import com.zgd.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}

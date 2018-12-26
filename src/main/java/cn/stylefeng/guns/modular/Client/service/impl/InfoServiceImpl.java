package cn.stylefeng.guns.modular.Client.service.impl;

import cn.stylefeng.guns.modular.system.model.Info;
import cn.stylefeng.guns.modular.system.dao.InfoMapper;
import cn.stylefeng.guns.modular.Client.service.IInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-21
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

}

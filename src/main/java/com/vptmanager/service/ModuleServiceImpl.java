package com.vptmanager.service;

import com.vptmanager.dao.ModuleDao;
import com.vptmanager.model.Module;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService{

    private ModuleDao moduleDao;

    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }

    @Override
    @Transactional
    public void addModule(Module module) {
        this.moduleDao.addModule(module);
    }

    @Override
    @Transactional
    public void updateModule(Module module) {
        this.moduleDao.updateModule(module);
    }

    @Override
    @Transactional
    public void removeModule(int idModule) {
        this.moduleDao.removeModule(idModule);
    }

    @Override
    @Transactional
    public Module getModuleById(int idModule) {
        return this.moduleDao.getModuleById(idModule);
    }

    @Override
    @Transactional
    public List<Module> listModules() {
        return this.moduleDao.listModules();
    }
}

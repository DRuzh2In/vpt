package com.vptmanager.dao;

import com.vptmanager.model.Module;

import java.util.List;

public interface ModuleDao {
    public void addModule(Module module);
    public void updateModule(Module module);
    public void removeModule(int idModule);
    public Module getModuleById(int idModule);
    public List<Module> listModules();
}

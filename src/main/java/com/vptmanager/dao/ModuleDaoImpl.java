package com.vptmanager.dao;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.vptmanager.model.Module;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModuleDaoImpl implements ModuleDao {
    private static final Logger logger = LoggerFactory.getLogger(ModuleDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addModule(Module module) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(module);
        logger.info("Module successfully saved. Module details: " + module);
    }

    @Override
    public void updateModule(Module module) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(module);
        logger.info("Module successfully update. Module details: " + module);
    }

    @Override
    public void removeModule(int idModule) {
        Session session = this.sessionFactory.getCurrentSession();
        Module module = (Module) session.load(Module.class, new Integer(idModule));

        if(module!=null){
            session.delete(module);
        }
        logger.info("Module successfully removed. Module details: " + module);
    }

    @Override
    public Module getModuleById(int idModule) {
        Session session =this.sessionFactory.getCurrentSession();
        Module module = (Module) session.load(Module.class, new Integer(idModule));
        logger.info("Module successfully loaded. Module details: " + module);

        return module;
    }

    @Override
    public List<Module> listModules() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Module> moduleList = session.createQuery("from Module").list();

        for(Module module: moduleList){
            logger.info("Module list: " + module);
        }

        return moduleList;
    }
}

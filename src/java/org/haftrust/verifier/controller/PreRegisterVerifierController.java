/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.controller;

import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.PreRegisterVerifierBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Miroslav
 */
public class PreRegisterVerifierController extends SimpleFormController
{
    private VerifierService verifierService;

    public VerifierService getVerifierService() {
        return verifierService;
    }

    public void setVerifierService(VerifierService verifierService) {
        this.verifierService = verifierService;
    }

    protected ModelAndView onSubmit(Object command) throws Exception
    {
        System.out.println("------------------------ controller preregister verifier onSubmit");

        PreRegisterVerifierBean prvBean = (PreRegisterVerifierBean) command;
        int id = 0;

        id = verifierService.preRegisterVerifier(prvBean.getEmail(), prvBean.getPassword());

        prvBean.setIdVerifier(id);

        return new ModelAndView(getSuccessView(), "prvBean", prvBean);
    }
}

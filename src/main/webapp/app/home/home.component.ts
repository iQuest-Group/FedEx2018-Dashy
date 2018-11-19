import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { Account, LoginModalService, Principal } from 'app/core';
import { ServiceModel } from 'app/core/home/service.model';
import { HomeService } from 'app/home/home.service';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;

    services: ServiceModel[];

    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private homeService: HomeService
    ) {}

    ngOnInit() {
        this.getInstances();
        // this.interval = setInterval(() => {
        //     this.getInstances();
        // }, 5000);
        this.principal.identity().then(account => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.principal.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    getInstances() {
        this.homeService.getInstances().subscribe(data => {
            console.log(data);
            this.services = data['services'];
        });
    }

    redirectToApp(url) {
        window.location.href = url;
    }
}

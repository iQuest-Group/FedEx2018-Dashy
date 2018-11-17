import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DashySharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent, HomeService } from './';

@NgModule({
    imports: [DashySharedModule, RouterModule.forChild([HOME_ROUTE])],
    declarations: [HomeComponent],
    providers: [HomeService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DashyHomeModule {}

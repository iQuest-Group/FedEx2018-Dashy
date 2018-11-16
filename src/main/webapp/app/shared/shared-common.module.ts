import { NgModule } from '@angular/core';

import { DashySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [DashySharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [DashySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class DashySharedCommonModule {}

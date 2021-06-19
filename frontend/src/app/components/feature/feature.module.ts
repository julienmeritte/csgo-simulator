import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeatureRoutingModule } from './feature-routing.module';
import { MainContainerComponent } from './main-container/main-container.component';
import { TeamsComponent } from './teams/teams.component';


@NgModule({
  declarations: [
    MainContainerComponent,
    TeamsComponent
  ],
  exports: [
    MainContainerComponent
  ],
  imports: [
    CommonModule,
    FeatureRoutingModule
  ]
})
export class FeatureModule { }

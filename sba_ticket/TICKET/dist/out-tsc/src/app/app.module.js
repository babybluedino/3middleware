var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { HomeComponent } from './component/home/home.component';
import { AddComponent } from './component/add/add.component';
import { GetallComponent } from './component/getall/getall.component';
import { GetbyidComponent } from './component/getbyid/getbyid.component';
import { DeleteComponent } from './component/delete/delete.component';
import { UpdateComponent } from './component/update/update.component';
var paths = [
    { path: '', component: HomeComponent },
    { path: 'listTasks', component: GetallComponent },
    //{path:'getByIdTasks',component:GetByIdTasksComponent},
    { path: 'addTicket', component: AddComponent },
    { path: 'updateTicket/:id', component: UpdateComponent },
    { path: 'deleteTicket/:id', component: DeleteComponent },
    { path: 'viewTicket/:id', component: GetbyidComponent }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        NgModule({
            declarations: [
                AppComponent,
                HomeComponent,
                AddComponent,
                GetallComponent,
                GetbyidComponent,
                DeleteComponent,
                UpdateComponent
            ],
            imports: [
                BrowserModule, HttpModule, FormsModule, RouterModule.forRoot(paths)
            ],
            providers: [],
            bootstrap: [AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
export { AppModule };
//# sourceMappingURL=app.module.js.map
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { SerService } from '../../service/ser.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Ticket } from '../../model/ticket';
var AddComponent = /** @class */ (function () {
    function AddComponent(ts, ar, router) {
        this.ts = ts;
        this.ar = ar;
        this.router = router;
    }
    AddComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.tickets = new Ticket();
        this.isUpdate = false;
        this.ar.params.subscribe(function (params) {
            var tid = params['id'];
            if (tid) {
                _this.ts.getByID(tid).subscribe(function (data) {
                    _this.tickets = data;
                    _this.isUpdate = true;
                });
            }
        });
    };
    AddComponent.prototype.save = function () {
        var _this = this;
        if (this.isUpdate) {
            this.ts.updateTicket(this.tickets).subscribe(function (data) {
                _this.router.navigateByUrl("/?opt=a&id=" + data.id);
            }, function (error) {
                alert("some error happened");
            });
        }
        else {
            this.ts.add(this.tickets).subscribe(function (data) {
                _this.router.navigateByUrl("/?opt=a&id=" + data.id);
            }, {});
        }
    };
    AddComponent = __decorate([
        Component({
            selector: 'app-add',
            templateUrl: './add.component.html',
            styleUrls: ['./add.component.css']
        }),
        __metadata("design:paramtypes", [SerService, ActivatedRoute, Router])
    ], AddComponent);
    return AddComponent;
}());
export { AddComponent };
//# sourceMappingURL=add.component.js.map
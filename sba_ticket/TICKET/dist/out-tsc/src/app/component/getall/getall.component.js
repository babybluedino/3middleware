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
import { ActivatedRoute } from '@angular/router';
var GetallComponent = /** @class */ (function () {
    function GetallComponent(ts, ar) {
        this.ts = ts;
        this.ar = ar;
    }
    GetallComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.ts.getAll().subscribe(function (data) { return _this.tickets = data; });
    };
    GetallComponent = __decorate([
        Component({
            selector: 'app-getall',
            templateUrl: './getall.component.html',
            styleUrls: ['./getall.component.css']
        }),
        __metadata("design:paramtypes", [SerService, ActivatedRoute])
    ], GetallComponent);
    return GetallComponent;
}());
export { GetallComponent };
//# sourceMappingURL=getall.component.js.map
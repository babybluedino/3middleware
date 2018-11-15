var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { map } from 'rxjs/operators';
var SerService = /** @class */ (function () {
    function SerService(http) {
        this.http = http;
        this.baseUrl = "http://localhost:6565/ticket/";
    }
    SerService.prototype.getBaseUrlForGetAll = function () {
        return this.baseUrl + "getall";
    };
    SerService.prototype.getAll = function () {
        return this.http.get(this.getBaseUrlForGetAll()).pipe(map(function (data) { return data.json(); }));
    };
    SerService.prototype.getJsonContentTypeHeader = function () {
        var headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return new RequestOptions({ headers: headers });
    };
    SerService.prototype.getBaseUrlForAdd = function () {
        return this.baseUrl + "add";
    };
    SerService.prototype.add = function (ticket) {
        return this.http.post(this.getBaseUrlForAdd(), JSON.stringify(ticket), this.getJsonContentTypeHeader()).pipe(map(function (data) { return data.json(); }));
    };
    SerService = __decorate([
        Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [Http])
    ], SerService);
    return SerService;
}());
export { SerService };
//# sourceMappingURL=ser.service.js.map
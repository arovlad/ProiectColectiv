import { NgModule } from '@angular/core';
import { LoginComponent } from "./login/login.component";
import { FormsModule } from '@angular/forms';

import { ActivatedRoute } from '@angular/router';

@NgModule({
    imports: [NgModule, FormsModule, ActivatedRoute],
    declarations: [LoginComponent]
})

export class AppModule implements OnInit{
    isLoggedIn : boolean;
    router: ActivatedRoute;

    ngOnInit() : void {
        if (this.isLoggedIn) {
            this.router.navigate(['/dashboard']);
        }
    }
}

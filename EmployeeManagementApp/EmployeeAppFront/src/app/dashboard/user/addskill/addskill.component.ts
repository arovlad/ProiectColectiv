import { Component, OnInit } from '@angular/core';
import { SkillService } from '../../../services/skill.service';
import {Router} from "@angular/router";
import {ILoginInformation} from "../../../auth/login/loginInformation";

@Component({
  selector: 'app-addskill',
  templateUrl: './addskill.component.html',
  styleUrls: ['./addskill.component.css']
})
export class AddskillComponent implements OnInit {
  username='';
  skillname='';
  skillLevel='';
  techAreas: Array<any> = [];
  techArea='';
  skillUsed = false;
  errMessageLevel =0;
  errMessageArea=0;
  errMessageSkillName=0;





  constructor(private skillService: SkillService,private router: Router) { }

  ngOnInit(): void {

    this.getAllTechAreas();

  }
saveSkill() {
  this.errMessageLevel =0;
  this.errMessageArea=0;
  this.errMessageSkillName=0;
    if((this.skillUsed == false) && (this.skillname!='') && (this.techArea != '') ) {

      this.skillService.saveSkill(this.skillname, this.techArea).subscribe(
        response => {
          alert("new skill added to database!");
          this.username='';
          this.skillname='';
          this.techArea='';
        },
        error => {
          alert('There was an error');
        }
      );
    }
    else if (this.skillUsed == true){
      alert("skill in database")
    }
     if(this.techArea==''){
      this.errMessageArea=1;
    }
    if(this.skillname==''){
      this.errMessageSkillName=1;
    }
    if(this.skillLevel==''){
      this.errMessageLevel=1;
    }

}



  getAllTechAreas() {
    this.skillService.getAllTechAreas().subscribe(
      (data) => {

        this.techAreas = data;
        console.log(this.techAreas);

      },
      (error) => {

        console.log("error");
      }
    );
  }
}

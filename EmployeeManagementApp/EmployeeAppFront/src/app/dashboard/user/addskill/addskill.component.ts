import { Component, OnInit } from '@angular/core';
import { SkillService } from '../../../services/skill.service';
import {Router} from "@angular/router";
import {ILoginInformation} from "../../../auth/login/loginInformation";
import {Observable} from "rxjs";

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

  idSkill=0;
  idUser=1;
  skillKnowledgeLevel=0;






  constructor(private skillService: SkillService,private router: Router) { }

  ngOnInit(): void {

    this.getAllTechAreas();

  }
  saveSkill() {
   this.errMessageLevel = 0;
   this.errMessageArea = 0;
   this.errMessageSkillName = 0;

    this.skillService.idSKill(this.skillname).subscribe(value => {

     this.idSkill = value;
     alert(this.idSkill);
     if ((this.idSkill == -1) && (this.skillname != '') && (this.techArea != '')) {
alert("enter if statment");
        this.skillService.saveSkill(this.skillname, this.techArea).subscribe(
         response => {
           alert("new skill added to Skills table!");
           this.skillService.idSKill(this.skillname).subscribe(data=>{
             this.idSkill=data;
             alert("second find");
             alert(this.idSkill);
             this.skillKnowledgeLevel= + this.skillLevel;
             alert("skill level: ");
             alert(this.skillKnowledgeLevel);
             alert("userID=");
             alert(this.idUser);
this.skillService.saveProfileSkill(this.idUser,this.idSkill,this.skillKnowledgeLevel).subscribe(dataa=>{
  alert("saved in profile skills");
},error=>{
  alert("error");
})



           },error=>{
             alert("error");
           })

         },
         error => {
           alert('There was an error');
         }
       );




     }

   }, error => {
     alert("wrong");
   });


 }



  getAllTechAreas() {
    this.skillService.getAllTechAreas().subscribe(
      (dataaa) => {

        this.techAreas = dataaa;
        console.log(this.techAreas);

      },
      (error) => {

        console.log("error");
      }
    );
  }
  async getId(){
    this.skillService.idSKill(this.skillname).subscribe(
      (dataa) => {
        this.idSkill=dataa;
        alert("masodik");
        alert(this.idSkill);

      },
      (error) => {

        console.log("error");
      }
    );
  }
}

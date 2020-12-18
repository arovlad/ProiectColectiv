import { Component, OnInit } from '@angular/core';
import {SkillService} from "../../../services/skill.service";
import{TechnologyareaService} from '../../../services/technologyarea.service';

@Component({
  selector: 'app-crud-technology-area',
  templateUrl: './crud-technology-area.component.html',
  styleUrls: ['./crud-technology-area.component.css']
})
export class CrudTechnologyAreaComponent implements OnInit {
  techAreas: Array<any> = [];
  name="";
  area="";
  newName="";
  constructor(private skillService: SkillService,private technologyService: TechnologyareaService) {

  }

  ngOnInit(): void {
    this.getAllTechAreas();
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
  delete(param: string){
    this.name=param;
    alert(this.name);
    this.technologyService.delete(this.name).subscribe((data)=>{
      alert("technology area deleted from database");
    },(error)=>{
      alert("something went wrong");
    })
  }
  insert(param: string) {
    this.newName = param;
    alert(this.newName);
    this.technologyService.save(this.newName).subscribe((data) => {
      alert("techology saved in database");
    },(error)=>{
      alert("something went worng");
    })


  }
}

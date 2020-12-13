import { Component, OnInit } from '@angular/core';
import {SkillService} from "../../../services/skill.service";

@Component({
  selector: 'app-crud-technology-area',
  templateUrl: './crud-technology-area.component.html',
  styleUrls: ['./crud-technology-area.component.css']
})
export class CrudTechnologyAreaComponent implements OnInit {
  techAreas: Array<any> = [];
  constructor(private skillService: SkillService) {

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
}

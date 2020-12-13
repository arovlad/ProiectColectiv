import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-skills',
  templateUrl: './add-skills.component.html',
  styleUrls: ['./add-skills.component.css']
})
export class AddSkillsComponent implements OnInit {
  addSkill = '';
  removeSkill = '';

  constructor() { }
// getAllSkill
  ngOnInit(): void {
  }

}

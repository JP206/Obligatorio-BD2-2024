import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FixtureAdminComponent } from './fixture-admin.component';

describe('FixtureAdminComponent', () => {
  let component: FixtureAdminComponent;
  let fixture: ComponentFixture<FixtureAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FixtureAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FixtureAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

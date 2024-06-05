import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PartidoFixtureComponent } from './partido-fixture.component';

describe('PartidoFixtureComponent', () => {
  let component: PartidoFixtureComponent;
  let fixture: ComponentFixture<PartidoFixtureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PartidoFixtureComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PartidoFixtureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
